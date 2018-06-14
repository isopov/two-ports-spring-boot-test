package com.example.parenttest.internal;

import com.example.parenttest.ChildContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@ChildContext
public class InternalModule {
    public static final String INTERNAL_PROFILE = "internal";

    @Configuration
    @EnableWebSecurity
    static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests().anyRequest().permitAll();
        }
    }

}