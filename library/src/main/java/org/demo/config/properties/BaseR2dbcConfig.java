package org.demo.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseR2dbcConfig {
    private R2dbcConnections r2dbc = new R2dbcConnections();
}
