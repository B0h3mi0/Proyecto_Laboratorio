//package com.laboratorio.LabUsuarios.service;
//
//import com.laboratorio.LabUsuarios.api.request.LoginRequest;
//import com.laboratorio.LabUsuarios.api.request.RegisterRequest;
//import com.laboratorio.LabUsuarios.api.request.TokenResponse;
//import com.laboratorio.LabUsuarios.model.TokenEntity;
//import com.laboratorio.LabUsuarios.model.UsuarioEntity;
//import com.laboratorio.LabUsuarios.repository.TokenRepository;
//import com.laboratorio.LabUsuarios.repository.UsuarioRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//    private TokenRepository tokenRepository;
//    private PasswordEncoder passwordEncoder;
//    private UsuarioRepository usuarioRepository;
//    private JwtService jwtService;
//
//    public TokenResponse register(RegisterRequest request){
//        var usuario = UsuarioEntity.builder()
//                .nomUsuario(request.nomUsuario())
//                .apUsuario(request.apUsuario())
//                .correo(request.correo())
//                .contrasena(passwordEncoder.encode(request.contrasena()))
//                .rol(request.rol())
//                .build();
//        var savedUsuario = usuarioRepository.save(usuario);
//        var jwtToken = jwtService.generateToken(usuario);
//        var refreshToken = jwtService.generateRefreshToken(usuario);
//        savedUsuarioToken(savedUsuario, jwtToken);
//        return new TokenResponse(jwtToken, refreshToken);
//    }
//
//    public TokenResponse login(LoginRequest request){
//        return null;
//    }
//
//    private void savedUsuarioToken(UsuarioEntity usuario, String jwtToken) {
//        var token = TokenEntity.builder()
//                .usuario(usuario)
//                .token(jwtToken)
//                .tokenType(TokenEntity.TokenType.BEARER)
//                .expired(false)
//                .revoked(false)
//                .build();
//        tokenRepository.save(token);
//    }
//
//    public TokenResponse refreshToken(String authHeader){
//        return null;
//    }
//
//}
