package com.zimsec.Security.userAuth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDto {
    private String full_name;
    private String id_number;
    private String email;
    private String phone_number;
    private String password;

    public String getFull_name() {
        return full_name;
    }
    public String getEmail() {
        return email;
    }
    public String getId_number(){return id_number;}
    public String getPassword() {
        return password;
    }
    public String getPhone_number() {
        return phone_number;
    }
}
