package com.example.spring.demospring.controller;

import com.example.spring.demospring.models.dao.IFacturaDao;
import com.example.spring.demospring.models.entity.Cuenta;
import com.example.spring.demospring.models.entity.Factura;
import com.example.spring.demospring.models.entity.RequestFactura;
import com.example.spring.demospring.models.service.CuentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class FacturaController {
    @Autowired
    IFacturaDao facturaDao;

    @Autowired
    CuentaService cuentaService;

    @GetMapping("/facturas")
    public List<Factura> index() {
        log.info("Retornando facturas ...");
        return facturaDao.findAll();
    }

    @PostMapping("/facturas")
    public ResponseEntity<?> findFacturasByJson(@RequestBody @Valid RequestFactura payload, BindingResult result) {
        if (result.hasErrors()){
            return new ResponseEntity<>(result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage), HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> response = new HashMap<>();
        try {
            Cuenta cuenta = cuentaService.findByContrato(payload.getContrato());
            response.put("cuenta", cuenta);
        } catch (Exception e) {
            response.put("mensaje", "No encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
