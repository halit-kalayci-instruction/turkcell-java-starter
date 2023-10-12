package com.turkcell.spring.starter.core.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        // JWT'ye ulaşmak => request'in headeri
        final String authHeader = request.getHeader("Authorization");

        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            // kullanıcı auth header göndermedi ya da geçersiz bir header gönderdi
            filterChain.doFilter(request,response);
            return;
        }
        final String jwt = authHeader.substring(7);
        // jwt içerisini kontrol etmek => jwt'yi decode/encode işlemleri
    }
}
