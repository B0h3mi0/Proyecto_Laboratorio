//package com.laboratorio.LabUsuarios.service;
//
//import com.laboratorio.LabUsuarios.model.UsuarioEntity;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//import java.util.Map;
//
//@Service
//public class JwtService {
//
//    @Value("${application.security.jwt.secret-key}")
//    private String secretKey;
//
//    @Value("${application.security.jwt.expiration}")
//    private Long jwtExpiration;
//
//    @Value("${application.security.jwt.refresh-token.expiration}")
//    private Long refreshExpiration;
//
//    public String generateToken (UsuarioEntity usuario) {
//        return buildToken(usuario, jwtExpiration);
//    }
//
//    public String generateRefreshToken (UsuarioEntity usuario) {
//        return buildToken(usuario, refreshExpiration);
//    }
//
//    private String buildToken(UsuarioEntity usuario, final long expiration) {
//        return Jwts.builder()
//                .id(usuario.getId().toString())
//                .claims(Map.of("nombre", usuario.getNomUsuario()))
//                .subject(usuario.getCorreo())
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(getSingInKey())
//                .compact();
//    }
//
//    private SecretKey getSingInKey(){
//        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//
//}
