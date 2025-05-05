package org.demo.service.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InternalBaseR2dbcConfig {
    private R2dbcConnections r2dbc = new R2dbcConnections();

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class R2dbcConnections {
        private MssqlConnections mssql = new MssqlConnections();
    }

    public static class MssqlConnections extends HashMap<String, MssqlConnectionConfig> {
        public MssqlConnections() {
            super();
        }

        public MssqlConnections(final Map<String, MssqlConnectionConfig> value) {
            super(value);
        }
    }

    @Getter
    @AllArgsConstructor
    public static class MssqlConnectionConfig {
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
}
