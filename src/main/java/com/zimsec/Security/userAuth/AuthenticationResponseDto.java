package com.zimsec.Security.userAuth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponseDto {
    private final String token;


    public AuthenticationResponseDto(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
