package com.example.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by a576097 on 18/08/2016.
 */
@Component
public class CustomHealthCheck implements HealthIndicator {
    public Health health() {
        int errorCode = 0;
        if (errorCode != 1) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

}