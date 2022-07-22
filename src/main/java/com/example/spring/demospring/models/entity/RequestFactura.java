package com.example.spring.demospring.models.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RequestFactura {

    @NotNull(message = "Nro de cuenta no debe ser vacio")
    private String nro_cuenta;

    @NotNull(message = "Nro de contrato no debe ser vacio")
    private String contrato;

    @NotNull
    @Pattern(regexp="^(AC|PE)$",message="Estado inválido")
    private String estado;
}
