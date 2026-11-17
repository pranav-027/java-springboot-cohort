package com.codingshuttle.securityApplication.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class LoggingFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Log the request details
        log.info("Incoming request: {} {}", request.getMethod(), request.getRequestURI());

        // Continue with the filter chain
        filterChain.doFilter(request, response);

        // Log the response details
        log.info("Outgoing response: {} {}", response.getStatus(), request.getRequestURI());
    }
}
