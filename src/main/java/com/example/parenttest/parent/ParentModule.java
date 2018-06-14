package com.example.parenttest.parent;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;

@SpringBootApplication(exclude = EmbeddedWebServerFactoryCustomizerAutoConfiguration.class)
public class ParentModule {
    public static final String PARENT_PROFILE = "parent";
}