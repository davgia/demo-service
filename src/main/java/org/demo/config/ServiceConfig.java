package org.demo.config;

import org.demo.config.properties.DemoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class ServiceConfig {

    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "demo")
    public DemoProperties getDemoProperties() {
        return new DemoProperties();
    }

    @Bean
    protected Boolean checkConfig(final DemoProperties properties) {
        final var value = Optional.ofNullable(properties.getRequiredSecret()).orElse("");
        System.out.println("Required secret value: " + value);
        if (!value.equals("loaded-from-secrets")) {
            throw new IllegalStateException("Required secret not loaded from secrets!");
        }
        return true;
    }
}
