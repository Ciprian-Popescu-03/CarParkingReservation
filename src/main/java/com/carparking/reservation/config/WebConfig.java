package com.carparking.reservation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Disable cache for all static resources
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")  // Default location for static files
                .setCachePeriod(0);  // Disable caching (set cache period to 0)
    }
}
