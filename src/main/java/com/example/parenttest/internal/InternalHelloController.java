package com.example.parenttest.internal;

import com.example.parenttest.parent.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal")
public class InternalHelloController {
    private final HelloService helloService;

    public InternalHelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public String hello() {
        return helloService.hello();
    }
}
