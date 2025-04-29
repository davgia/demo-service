package org.demo.config.properties;

public class DemoProperties {
    private String requiredSecret;

    public DemoProperties() {}

    public String getRequiredSecret() {
        return requiredSecret;
    }

    public void setRequiredSecret(final String requiredSecret) {
        this.requiredSecret = requiredSecret;
    }
}
