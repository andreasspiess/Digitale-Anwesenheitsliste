package com.example.DigitaleAnwesenheitsliste.Persons.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/student").setViewName("student");
        registry.addViewController("/dozent").setViewName("dozent");
        registry.addViewController("/login").setViewName("login");
    }
}