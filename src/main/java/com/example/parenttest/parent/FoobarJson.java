package com.example.parenttest.parent;

import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
public interface FoobarJson {
        @Nullable
        Long id();
        String val();
}
