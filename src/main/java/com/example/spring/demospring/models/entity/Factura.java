package com.example.spring.demospring.models.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Factura {

    private Long id;
    private Date fechaEmision;
    private Boolean estado;
    private String nroFactura;
    private Integer monto;

    private Cuenta cuenta;
}
