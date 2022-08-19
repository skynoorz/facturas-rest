package com.example.spring.demospring.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaEmision;
    private Boolean estado;
    private String nroFactura;
    private Integer monto;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cuenta cuenta;

    public Factura(Long id, Date fechaEmision, Boolean estado, String nroFactura, Integer monto) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.nroFactura = nroFactura;
        this.monto = monto;
    }
}
