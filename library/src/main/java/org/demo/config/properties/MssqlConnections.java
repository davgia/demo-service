package org.demo.config.properties;

import java.util.HashMap;
import java.util.Map;

public class MssqlConnections extends HashMap<String, MssqlConnectionConfig> {
    public MssqlConnections() {
        super();
    }

    public MssqlConnections(final Map<String, MssqlConnectionConfig> value) {
        super(value);
    }
}
