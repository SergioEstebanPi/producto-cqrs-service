package com.msvc.cqrs.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoRestModel {
    private String productoId;
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;
}
