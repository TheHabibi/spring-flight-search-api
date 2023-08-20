package com.ali.flightsearch.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.desktop.SystemSleepEvent;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApiKeyGenerator implements CommandLineRunner {

    public String apiKey;

    public String generateApiKey() {
        apiKey = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        return apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    @Override
    public void run(String... args) throws Exception {
        apiKey = generateApiKey();
        System.out.println("Generated API Key: " + apiKey);
    }
}







