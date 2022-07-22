package com.example.spring.demospring.models.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestFactura {

    @NotNull(message = "Nro de cuenta no debe ser vacio")
    private String nro_cuenta;

    @NotNull(message = "Nro de contrato no debe ser vacio")
    private String contrato;

    @Size(min = 2, max = 2, message = "El estado solo debe tener dos caracteres")
    @NotNull
    private String estado;
}
