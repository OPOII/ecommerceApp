package com.example.ecommerce.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserRol {
    @JsonProperty("Admin")
    Admin,
    @JsonProperty("User")
    User
}

