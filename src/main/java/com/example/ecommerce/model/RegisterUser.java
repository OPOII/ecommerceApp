package com.example.ecommerce.model;

import com.example.ecommerce.utils.IdentityType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUser {

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
