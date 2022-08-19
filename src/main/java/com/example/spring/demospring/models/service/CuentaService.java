package com.example.spring.demospring.models.service;

import com.example.spring.demospring.models.entity.Cuenta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CuentaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cuenta findByCyC(String contrato, String nroCuenta) {
        String query = "SELECT * FROM CUENTA WHERE CONTRATO=? AND NRO_CUENTA=?";
        Cuenta cuenta = (Cuenta) jdbcTemplate.queryForObject(
                query,
                new Object[]{contrato, nroCuenta},
                new BeanPropertyRowMapper(Cuenta.class));

        log.info("Retornando cuentas...");
        return cuenta;
    }

}
