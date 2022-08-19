package com.example.spring.demospring.models.service;

import com.example.spring.demospring.models.entity.Cuenta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class CuentaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cuenta findByCyC(String contrato, String nroCuenta) throws SQLException {

        String sql = "SELECT * FROM Students";
        List<Cuenta> cuentas = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Cuenta.class));

        cuentas.forEach(System.out :: println);
        return new Cuenta();
    }

}
