package org.demo.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class R2dbcConnections {
    private MssqlConnections mssql = new MssqlConnections();
}
