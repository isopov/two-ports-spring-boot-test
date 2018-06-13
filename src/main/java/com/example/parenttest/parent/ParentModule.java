package com.example.parenttest.parent;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ParentModule {
    public static final String PARENT_PROFILE = "parent";
}