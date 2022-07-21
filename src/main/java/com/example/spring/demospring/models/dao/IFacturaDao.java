package com.example.spring.demospring.models.dao;

import com.example.spring.demospring.models.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaDao extends JpaRepository<Factura, Long> {
}
