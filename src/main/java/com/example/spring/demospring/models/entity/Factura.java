package com.example.spring.demospring.models.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Factura {

    @Id
    private Long id;
    private String nroCuenta;
    private Date fechaEmision;
    private Integer contrato;
    private Boolean estado;
    private String nombre;
    private String ci;
    private String nroFactura;
    private Integer monto;
}
