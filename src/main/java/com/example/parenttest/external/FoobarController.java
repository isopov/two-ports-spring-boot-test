package com.example.parenttest.external;

import com.example.parenttest.parent.FoobarConverter;
import com.example.parenttest.parent.FoobarJson;
import com.example.parenttest.parent.FoobarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/foobar")
public class FoobarController {
    protected final FoobarRepository foobarRepository;

    public FoobarController(FoobarRepository foobarRepository) {
        this.foobarRepository = foobarRepository;
    }

    @GetMapping
    public List<FoobarJson> listAll() {
        return foobarRepository.findAll()
                .stream()
                .map(FoobarConverter::toJson)
                .collect(Collectors.toList());
    }

    @PutMapping
    public FoobarJson put(FoobarJson foobar) {
        return FoobarConverter.toJson(
                foobarRepository.save(
                        FoobarConverter.toEntity(foobar)
                )
        );
    }

}
