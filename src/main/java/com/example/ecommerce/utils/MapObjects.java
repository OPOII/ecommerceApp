package com.example.ecommerce.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class MapObjects {
    public static Object convertRequestToObject(String json, Type type){
        return new Gson().fromJson(json, type);
    }
}
