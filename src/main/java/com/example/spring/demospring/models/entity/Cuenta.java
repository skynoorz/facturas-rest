package com.example.spring.demospring.models.entity;

import lombok.Data;
import java.util.List;

@Data
public class Cuenta {

    private Long id;
    private String contrato;
    private String nroCuenta;
    private String estado;
    private String nombres;
    private String ci;
    private List<Factura> facturas;
}
