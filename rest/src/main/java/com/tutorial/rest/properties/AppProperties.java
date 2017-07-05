package com.tutorial.rest.properties;

import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@ConfigurationProperties
@Validated
@Getter
public class AppProperties {

    private Server server;

    private Security security;

    @Valid
    private Datasource datasource;

    @ConfigurationProperties("server")
    public static class Server {
        private int port;
    }

    @ConfigurationProperties("management.security")
    @Getter
    public static class Security {
        private boolean enabled;
    }

    @ConfigurationProperties("spring.datasource")
    @Getter
    public static class Datasource {
        @NotEmpty
        private String url;
        @NotEmpty
        private String name;
    }
}

