package com.invexia.inventario.service;

import com.invexia.inventario.entity.UsuarioEntity;
import com.invexia.inventario.repository.UsuarioRepository;
import com.invexia.inventario.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String register(String username, String password) {
        UsuarioEntity user = UsuarioEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .rol("USER")
                .build();
        usuarioRepository.save(user);
        return "Usuario registrado con éxito";
    }

    public String login(String username, String password) {
        UsuarioEntity user = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return jwtUtil.generateToken(username);
    }
}
