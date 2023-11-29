package com.example.mypasteapp.web;

import com.example.mypasteapp.model.DTO.requests.AuthenticationRequest;
import com.example.mypasteapp.model.DTO.responses.AuthenticationResponse;
import com.example.mypasteapp.config.security.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

  private final AuthenticationService service;

  public AuthController(AuthenticationService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }


}
