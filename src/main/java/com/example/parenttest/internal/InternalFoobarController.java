package com.example.parenttest.internal;

import com.example.parenttest.external.FoobarController;
import com.example.parenttest.parent.FoobarRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/foobar")
public class InternalFoobarController extends FoobarController{
    public InternalFoobarController(FoobarRepository foobarRepository) {
        super(foobarRepository);
    }

    @DeleteMapping
    public void deleteAll(){
        foobarRepository.deleteAll();
    }
}
