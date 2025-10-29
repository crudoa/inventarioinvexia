package com.invexia.inventario.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println("➡️ [Filtro JWT] Path: " + path);

        // Saltar autenticación en /api/auth
        if (path.startsWith("/api/auth/")) {
            System.out.println("🔹 [Filtro JWT] Petición pública, no requiere token");
            filterChain.doFilter(request, response);
            return;
        }

        // Cabecera Authorization
        String authHeader = request.getHeader("Authorization");
        System.out.println("🔹 [Filtro JWT] Header Authorization: " + authHeader);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("⚠️ [Filtro JWT] No hay token válido en cabecera");
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        System.out.println("✅ [Filtro JWT] Token recibido: " + token);

        if (!jwtUtil.validateToken(token)) {
            System.out.println("❌ [Filtro JWT] Token inválido");
            filterChain.doFilter(request, response);
            return;
        }

        String username = jwtUtil.extractUsername(token);
        System.out.println("✅ [Filtro JWT] Token válido, usuario extraído: " + username);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        new User(username, "", Collections.emptyList()),
                        null,
                        Collections.emptyList()
                );

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("🔐 [Filtro JWT] Usuario autenticado correctamente");
        filterChain.doFilter(request, response);
    }
}
