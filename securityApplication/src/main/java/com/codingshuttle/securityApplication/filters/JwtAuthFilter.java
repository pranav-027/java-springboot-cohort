package com.codingshuttle.securityApplication.filters;

import com.codingshuttle.securityApplication.entities.User;
import com.codingshuttle.securityApplication.services.impl.JwtService;
import com.codingshuttle.securityApplication.services.impl.SessionsService;
import com.codingshuttle.securityApplication.services.impl.UserServiceAdaptor;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserServiceAdaptor userService;
    private final SessionsService sessionsService;

    private final HandlerExceptionResolver handlerExceptionResolver;

    public JwtAuthFilter(JwtService jwtService, UserServiceAdaptor userService, SessionsService sessionsService, @Qualifier("handlerExceptionResolver") HandlerExceptionResolver handlerExceptionResolver) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.sessionsService = sessionsService;
        this.handlerExceptionResolver = handlerExceptionResolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {

        try {
            final String requestHeaderToken = request.getHeader("Authorization");
            if (requestHeaderToken == null || !requestHeaderToken.startsWith("Bearer ")) {
                log.info("No JWT token found in request headers, proceeding without authentication.");
                filterChain.doFilter(request, response);
                return;
            }

            String token = requestHeaderToken.substring(7); // Remove "Bearer " w

            Long userId = jwtService.getUserIdFromToken(token);

            if (!sessionsService.isSessionValid(userId, token)) {
                log.info("Invalid session for user ID: {}", userId);
                filterChain.doFilter(request, response);
                return;
            }

            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                log.info("Authenticated user with ID: {}", userId);
                User user = userService.getUserById(userId);
                UsernamePasswordAuthenticationToken authenticationToken = UsernamePasswordAuthenticationToken.authenticated(user, null, user.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            handlerExceptionResolver.resolveException(request, response, null, e);
        }
    }
}
