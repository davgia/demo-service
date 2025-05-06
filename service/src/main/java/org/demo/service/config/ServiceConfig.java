package org.demo.service.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.demo.config.properties.BaseR2dbcConfig;
import org.demo.service.config.properties.InternalBaseR2dbcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Slf4j
@Configuration
public class ServiceConfig {

    @Autowired
    protected ObjectMapper objectMapper;

    @Bean
    @ConfigurationProperties(prefix = "demo.connections")
    public InternalBaseR2dbcConfig getInternalR2dbcConfig() {
        return new InternalBaseR2dbcConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "demo.connections")
    public BaseR2dbcConfig getExternalR2dbcConfig() {
        return new BaseR2dbcConfig();
    }

    @Bean
    protected Boolean checkInternalConfig(final InternalBaseR2dbcConfig config) throws JsonProcessingException {
        final var serialized = objectMapper.writeValueAsString(config.getR2dbc().getMssql().entrySet());

        log.info("Internal: {}", serialized);

        final var conn = config.getR2dbc().getMssql().values().stream().findFirst().orElseThrow();
        if (Objects.equals(conn.getUri(), "") || Objects.equals(conn.getPassword(), "")) {
            throw new IllegalStateException("Required secret not loaded from secrets!");
        }

        return true;
    }

    @Bean
    protected Boolean checkConfig(final BaseR2dbcConfig config) throws JsonProcessingException {
        final var serialized = objectMapper.writeValueAsString(config.getR2dbc().getMssql().entrySet());

        log.info("External: {}", serialized);

        final var conn = config.getR2dbc().getMssql().values().stream().findFirst().orElseThrow();
        if (Objects.equals(conn.getUri(), "") || Objects.equals(conn.getPassword(), "")) {
            throw new IllegalStateException("Required secret not loaded from secrets!");
        }

        return true;
    }
}
