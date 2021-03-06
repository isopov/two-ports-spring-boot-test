package com.example.parenttest;

import com.example.parenttest.external.ExternalModule;
import com.example.parenttest.internal.InternalModule;
import com.example.parenttest.parent.ParentModule;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ParentTestApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ParentModule.class)
                .profiles(ParentModule.PARENT_PROFILE)
                .child(ExternalModule.class)
                .profiles(ExternalModule.EXTERNAL_PROFILE)
                .bannerMode(Banner.Mode.OFF) //we have two applications - external and internal - leave banner only for one
                .sibling(new Class<?>[]{InternalModule.class}, args)
                .profiles(InternalModule.INTERNAL_PROFILE)
                .run(args);
    }
}
