package com.ali.flightsearch.filter;

import com.ali.flightsearch.security.ApiKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    private final ApiKeyGenerator apiKeyGenerator;

    @Autowired
    public ApiKeyFilter(ApiKeyGenerator apiKeyGenerator) {
        this.apiKeyGenerator = apiKeyGenerator;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String apiKey = request.getHeader("Amadeus-API-Key"); // Adjust the header name as needed

        if (apiKey != null && apiKey.equals(apiKeyGenerator.getApiKey())) {
            filterChain.doFilter(request, response); // Proceed with the request
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
