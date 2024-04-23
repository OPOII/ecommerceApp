package com.example.ecommerce.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum IdentityType {
    @JsonProperty("CC")
    CC,
    @JsonProperty("NIT")
    NIT,
    @JsonProperty("PASSPORT")
    PASSPORT,
    @JsonProperty("TI")
    TI,
    @JsonProperty("ANI")
    ANI

}
