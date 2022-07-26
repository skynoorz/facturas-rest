package com.example.spring.demospring.models.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contrato;
    private String nroCuenta;
    private String estado;
    private String nombres;
    private String ci;
    
    @OneToMany(mappedBy = "cuenta")
    private List<Factura> facturas;
}
