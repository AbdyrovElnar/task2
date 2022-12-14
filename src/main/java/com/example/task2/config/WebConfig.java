package com.example.task2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
//        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
//        registry.addResourceHandler("/uploads/**").addResourceLocations("file:uploads/");
//        registry.addResourceHandler("/uploads/**").addResourceLocations("file:uploads/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/").resourceChain(false);
    }

}
