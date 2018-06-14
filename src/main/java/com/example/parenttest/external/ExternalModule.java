package com.example.parenttest.external;

import com.example.parenttest.ChildContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@ChildContext
public class ExternalModule {
    public static final String EXTERNAL_PROFILE = "external";

    @Configuration
    static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests().anyRequest().authenticated().and().oauth2Login();
        }
    }

}