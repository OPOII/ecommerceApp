package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private Long id;
    private int cantidad;
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precio;
}
