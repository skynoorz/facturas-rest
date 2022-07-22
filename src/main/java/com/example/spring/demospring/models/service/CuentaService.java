package com.example.spring.demospring.models.service;

import com.example.spring.demospring.models.dao.ICuentaDao;
import com.example.spring.demospring.models.entity.Cuenta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CuentaService {

    @Autowired
    ICuentaDao cuentaDao;

    public Cuenta findByContrato(String contrato) {
        return this.cuentaDao.findByContrato(contrato);
    }
}
