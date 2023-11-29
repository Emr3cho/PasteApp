package com.example.mypasteapp.config.security;

import com.example.mypasteapp.model.DTO.requests.AuthenticationRequest;
import com.example.mypasteapp.model.DTO.responses.AuthenticationResponse;
import com.example.mypasteapp.config.JWT.JwtService;
import com.example.mypasteapp.dao.UserRepository;
import com.example.mypasteapp.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UserInfoService userInfoService;

  public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, UserInfoService userInfoService) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
    this.userInfoService = userInfoService;
  }

  public AuthenticationResponse register(AuthenticationRequest request) {
    var user = new User(request.getUsername(), passwordEncoder.encode(request.getPassword()));
    var savedUser = repository.save(user);
    UserInfo userInfo = new UserInfo(savedUser);
    var jwtToken = jwtService.generateToken(userInfo);
    var refreshToken = jwtService.generateRefreshToken(userInfo);
    return new AuthenticationResponse(jwtToken, refreshToken);
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );
    var user = userInfoService.loadUserByUsername(request.getUsername());
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    return new AuthenticationResponse(jwtToken, refreshToken);
  }


  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtService.extractUsername(refreshToken);
    if (userEmail != null) {
      var user = this.userInfoService.loadUserByUsername(userEmail);
      if (jwtService.isTokenValid(refreshToken, user)) {
        var accessToken = jwtService.generateToken(user);
        var authResponse = new AuthenticationResponse(accessToken, refreshToken);
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }
}
