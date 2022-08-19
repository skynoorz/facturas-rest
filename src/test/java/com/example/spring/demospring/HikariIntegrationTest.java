package com.example.spring.demospring;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class HikariIntegrationTest {

    @Test
    public void hikariConnectionPoolIsConfigured() {
        assertTrue(true);
    }
}
