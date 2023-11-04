package com.fleetmanagement.fleet.DTO;

import org.springframework.stereotype.Component;

@Component
public class AuthResponseDTO 
{

    private String accessToken;
    private String tokenType = "Bearer ";

    public AuthResponseDTO() {
    }

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
