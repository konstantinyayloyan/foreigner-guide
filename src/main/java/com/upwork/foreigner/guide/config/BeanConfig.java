package com.upwork.foreigner.guide.config;

import com.upwork.foreigner.guide.controller.PlaceController;
import com.upwork.foreigner.guide.exception.PlaceNotFoundException;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig extends ResourceConfig {

    public BeanConfig() {
        register(PlaceController.class);
        register(PlaceNotFoundException.class);
    }
}
