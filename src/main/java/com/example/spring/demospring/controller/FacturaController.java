package com.example.spring.demospring.controller;

import com.example.spring.demospring.models.dao.IFacturaDao;
import com.example.spring.demospring.models.entity.Factura;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class FacturaController {
    @Autowired
    IFacturaDao facturaDao;

    @GetMapping("/facturas")
    public List<Factura> index(){
        log.info("Retornando facturas ...");
        return facturaDao.findAll();
    }
}
