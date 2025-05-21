package com.springboot.preparation.actuator;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomActuator implements HealthIndicator {


    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        int code = check();
        if (code != 0){
            return Health.down().withDetail("Error Code",code).build();
        }
        return Health.up().build();
    }

    private int check() {
        return 0;
    }
}
