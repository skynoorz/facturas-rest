package com.example.spring.demospring;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@NoArgsConstructor
public class DataSourceConfig {
    private static final HikariConfig config = new HikariConfig("hikari.properties");
    private static HikariDataSource ds;


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
