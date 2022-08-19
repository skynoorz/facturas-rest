package com.example.spring.demospring.models.dao;

import com.example.spring.demospring.models.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class ICuentaDao {

    @Autowired
    protected JdbcTemplate jtm;

    public static Cuenta findByContratoAndNroCuenta(String contrato, String nroCuenta) throws SQLException {
        String SQL_QUERY = "select * from emp";
        Cuenta cuenta = null;
//        try (Connection con = DataSource.getConnection();
//             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
//             ResultSet rs = pst.executeQuery();) {
//             while (rs.next()) {
//                 cuenta = new Cuenta();
//                cuenta.setNroCuenta(rs.getString("nro_cuenta"));
//                    cuenta.setCi(rs.getString("ci"));
//                    cuenta.setEstado(rs.getString("estado"));
//                    cuenta.setNombres(rs.getString("nombres"));
//                    cuenta.setId(rs.getLong("id"));
//             }
//        }
        return cuenta;
    }
}
