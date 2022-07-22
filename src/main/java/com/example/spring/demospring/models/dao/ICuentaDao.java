package com.example.spring.demospring.models.dao;

import com.example.spring.demospring.models.entity.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ICuentaDao extends CrudRepository<Cuenta, Long> {

    @Query("FROM Cuenta WHERE contrato = ?1")
    public Cuenta findByContrato(String contrato);
}
