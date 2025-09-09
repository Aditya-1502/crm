package com.jsp.crm.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jsp.crm.model.AdminConfig;
import com.jsp.crm.repository.AdminConfigRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initRootEmail(AdminConfigRepository repository) {
        return args -> {
            // Check if email already exists
            if (repository.findById(1L).isEmpty()) {
                AdminConfig config = new AdminConfig();
                config.setEmail("adispartan111@gmail.com"); // initial root email
                repository.save(config); // save to database
            }
        };
    }
}
