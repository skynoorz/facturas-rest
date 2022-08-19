package com.example.spring.demospring.models.service;

import com.example.spring.demospring.models.entity.Cuenta;
import com.example.spring.demospring.models.entity.Factura;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

@Service
@Slf4j
public class CuentaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cuenta> findByContratoAndCuenta(String contrato, String nroCuenta) {
        String query = "select c.id as id_cuenta, c.ci, c.contrato, c.estado as estado_cuenta, c.nombres, c.nro_cuenta, factura.id as id_factura, factura.estado as estado_factura, factura.fecha_emision, factura.monto, factura.nro_factura, factura.cuenta_id " +
                "from cuenta c left join factura on c.id = factura.cuenta_id where c.contrato="+contrato+" and c.nro_cuenta="+nroCuenta;
        List<Cuenta> cuentas = new ArrayList<>(Objects.requireNonNull(jdbcTemplate.query(
                query, rs -> {
                    Map<Long, Cuenta> cuentaById = new HashMap<>();
                    while (rs.next()) {
                        Long id = rs.getLong("id_cuenta");
                        String ci = rs.getString("ci");
                        String contrato1 = rs.getString("contrato");
                        String nroCuenta1 = rs.getString("nro_cuenta");
                        String estadoCuenta = rs.getString("estado_cuenta");
                        String nombres = rs.getString("nombres");
                        Cuenta cuentaT = cuentaById.get(id);
                        if (cuentaT == null) {
                            cuentaT = new Cuenta(id, contrato1, nroCuenta1, estadoCuenta, nombres, ci, new ArrayList<>());
                            cuentaById.put(cuentaT.getId(), cuentaT);
                        }
                        Long idFactura = rs.getLong("id_factura");
                        Date fechaEmision = rs.getDate("fecha_emision");
                        Boolean estadoFactura = rs.getBoolean("estado_factura");
                        String nroFactura = rs.getString("nro_factura");
                        Integer monto = rs.getInt("monto");
                        cuentaT.addFactura(new Factura(idFactura, fechaEmision, estadoFactura, nroFactura, monto));
                    }
                    return cuentaById.values();
                })));
        log.info("Retornando cuentas...");
        return cuentas;
    }
}
