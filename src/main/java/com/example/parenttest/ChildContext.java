package com.example.parenttest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
        import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
        import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
        import org.springframework.context.annotation.ComponentScan;

        import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited

@ComponentScan
@EnableAutoConfiguration
@ImportAutoConfiguration(EmbeddedWebServerFactoryCustomizerAutoConfiguration.class)
public @interface ChildContext {
}
