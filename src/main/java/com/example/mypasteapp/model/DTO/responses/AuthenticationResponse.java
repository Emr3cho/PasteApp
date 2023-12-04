package com.example.mypasteapp.model.DTO.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;

  public AuthenticationResponse(String accessToken) {
    this.accessToken = accessToken;
  }
}
