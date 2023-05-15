package com.example.indicator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HealthIndicator extends AbstractHealthIndicator {

    /**
     * defined health checking output the result
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up()
                .withDetail("status", "200")
                .withDetail("whoami", "chenliu")
                .withDetail("uptime", new Date());
    }
}
