package com.example.spring.demospring.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    public void addFactura(Factura factura) {
            this.facturas.add(factura);
    }

    public Cuenta(Long id, String contrato, String nroCuenta, String estado, String nombres, String ci, ArrayList<Factura> facturas) {
        this.id = id;
        this.contrato = contrato;
        this.nroCuenta = nroCuenta;
        this.estado = estado;
        this.nombres = nombres;
        this.ci = ci;
        this.facturas = facturas;
    }
}
