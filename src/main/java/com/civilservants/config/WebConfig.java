package com.civilservants.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Configure the default route to serve the React app
        registry.addViewController("/")
                .setViewName("forward:/index.html");

        // Add a ViewController for the "/about" route
        registry.addViewController("/about")
                .setViewName("forward:/index.html");

        registry.addViewController("/userDistrict")
                .setViewName("forward:/index.html");
    }

}
