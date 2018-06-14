package com.example.parenttest.parent;

public final class FoobarConverter {
    private FoobarConverter() {
    }

    public static FoobarJson toJson(Foobar foobar){
        return ImmutableFoobarJson.builder()
                .id(foobar.getId())
                .val(foobar.getVal())
                .build();
    }

    public static Foobar toEntity(FoobarJson json){
        Foobar foobar = new Foobar();
        foobar.setId(json.id());
        foobar.setVal(json.val());
        return foobar;
    }
}
