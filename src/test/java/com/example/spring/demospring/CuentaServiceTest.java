package com.example.spring.demospring;

import com.example.spring.demospring.models.entity.Cuenta;
import com.example.spring.demospring.models.service.CuentaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CuentaServiceTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    CuentaService cuentaService;

    @Test
    public void findByContratoAndCuentaTest() {
        List<Cuenta> cuentasMock = new ArrayList<>(List.of(new Cuenta(1L, "1", "2", "3", "4", "5", null)));

        ReflectionTestUtils.setField(cuentaService, "jdbcTemplate", jdbcTemplate);
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), (ResultSetExtractor<Object>) Mockito.any()))
                .thenReturn(cuentasMock);

        assertEquals(cuentaService.findByContratoAndCuenta("1", "2").size(), 1);
    }
}
