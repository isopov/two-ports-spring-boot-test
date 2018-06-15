package com.example.parenttest.external;

import com.example.parenttest.ChildContext;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

@ChildContext
public class ExternalModule {
    public static final String EXTERNAL_PROFILE = "external";

    @Configuration
    static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        private final ManagementServerProperties managementServerProperties;

        SecurityConfiguration(ManagementServerProperties managementServerProperties) {
            this.managementServerProperties = managementServerProperties;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .requestMatchers(forPort(managementServerProperties.getPort())).permitAll()
                    .anyRequest().authenticated().and().oauth2Login();
        }

        private static RequestMatcher forPort(final int port) {
            return request -> port == request.getLocalPort();
        }
    }

}