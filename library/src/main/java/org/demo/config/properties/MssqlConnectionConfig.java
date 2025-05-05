package org.demo.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

@Getter
@AllArgsConstructor
public class MssqlConnectionConfig {
    private String uri;
    private Duration connectTimeout;
    private String database;
    private String driver;
    private String host;
    private Duration lockWaitTimeout;
    private String password;
    private Integer port;
    private String protocol;
    private Boolean ssl;
    private Duration statementTimeout;
    private String user;
}
