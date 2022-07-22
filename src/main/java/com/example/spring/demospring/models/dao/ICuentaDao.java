package com.example.spring.demospring.models.dao;

import com.example.spring.demospring.models.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

public interface ICuentaDao extends CrudRepository<Cuenta, Long> {

    Cuenta findByContratoAndNroCuenta(String contrato, String nroCuenta);
}
