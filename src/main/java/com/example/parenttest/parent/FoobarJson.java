package com.example.parenttest.parent;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.immutables.value.Value;

import javax.annotation.Nullable;

@ApiModel(description = "Foobar description")
@Value.Immutable
@JsonDeserialize(builder = ImmutableFoobarJson.Builder.class)
public interface FoobarJson {
        @ApiModelProperty(value = "foobar id", allowEmptyValue = true)
        @Nullable
        @JsonProperty
        Long id();

        @ApiModelProperty(value = "foobar value")
        @JsonProperty
        String val();
}
