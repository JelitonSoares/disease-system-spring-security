package com.zex.spring_security.infra.security;

import com.zex.spring_security.infra.token.TokenService;
import com.zex.spring_security.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository repository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = getToken(request);

        if (tokenJWT != null) {
            String login = tokenService.verifyToken(tokenJWT);

            UserDetails user = repository.findByLogin(login);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }


        filterChain.doFilter(request, response);
    }

    public String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null) {
            return token.replace("Bearer ", "");
        }

        return null;
    }
}
