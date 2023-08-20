package com.ali.flightsearch.configuration;

import com.ali.flightsearch.filter.ApiKeyFilter;
import com.ali.flightsearch.security.ApiKeyGenerator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiKeyConfig {

    private final ApiKeyGenerator apiKeyGenerator; // Inject the ApiKeyGenerator bean

    public ApiKeyConfig(ApiKeyGenerator apiKeyGenerator) {
        this.apiKeyGenerator = apiKeyGenerator;
    }

    @Bean
    public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter() {
        FilterRegistrationBean<ApiKeyFilter> registrationBean = new FilterRegistrationBean<>();

        // Pass the ApiKeyGenerator instance to the ApiKeyFilter constructor
        registrationBean.setFilter(new ApiKeyFilter(apiKeyGenerator));

        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}