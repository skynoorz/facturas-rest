package com.example.spring.demospring.models.service;

import static com.example.spring.demospring.models.dao.ICuentaDao.findByContratoAndNroCuenta;
import com.example.spring.demospring.models.entity.Cuenta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@Slf4j
public class CuentaService {

    public Cuenta findByCyC(String contrato, String nroCuenta) throws SQLException {
        return findByContratoAndNroCuenta(contrato, nroCuenta);
    }

}
