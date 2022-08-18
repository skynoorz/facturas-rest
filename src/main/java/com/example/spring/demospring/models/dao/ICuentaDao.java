package com.example.spring.demospring.models.dao;

import com.example.spring.demospring.DataSource;
import com.example.spring.demospring.models.entity.Cuenta;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ICuentaDao {

    public static Cuenta findByContratoAndNroCuenta(String contrato, String nroCuenta) throws SQLException {
        String SQL_QUERY = "select * from emp";
        Cuenta cuenta = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery();) {
             while (rs.next()) {
                 cuenta = new Cuenta();
                cuenta.setNroCuenta(rs.getString("nro_cuenta"));
                    cuenta.setCi(rs.getString("ci"));
                    cuenta.setEstado(rs.getString("estado"));
                    cuenta.setNombres(rs.getString("nombres"));
                    cuenta.setId(rs.getLong("id"));
             }
        }
        return cuenta;
    }
}
