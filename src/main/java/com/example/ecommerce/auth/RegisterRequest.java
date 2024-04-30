package com.example.ecommerce.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String middleName;
    private String secondName;
    private String lastName;
    private String username;
    private String identification;
    private String identificationNumber;
    private String email;
    private String direction;
    private String phone;
    private String password;
    private String password2;
}
