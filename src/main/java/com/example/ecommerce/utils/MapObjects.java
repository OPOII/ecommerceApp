package com.example.ecommerce.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class MapObjects {
    public static Object convertRequestToObject(String json, Type type){
        System.out.println(json);   
        var ob=new Gson().toJson(json);

        return new Gson().fromJson(ob, type);
    }
}
