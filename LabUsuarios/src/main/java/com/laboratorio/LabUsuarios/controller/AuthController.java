//package com.laboratorio.LabUsuarios.controller;
//
//import com.laboratorio.LabUsuarios.api.request.LoginRequest;
//import com.laboratorio.LabUsuarios.api.request.RegisterRequest;
//import com.laboratorio.LabUsuarios.api.request.TokenResponse;
//import com.laboratorio.LabUsuarios.service.AuthService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//@RequiredArgsConstructor
//public class AuthController {
//    private  AuthService service;
//
//    @PostMapping("/register")
//    public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequest request){
//        TokenResponse token = service.register(request);
//        return ResponseEntity.ok(token);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<TokenResponse> authenticate(@RequestBody LoginRequest request){
//        TokenResponse token = service.login(request);
//        return ResponseEntity.ok(token);
//    }
//
//    @PostMapping("/refresh")
//    public TokenResponse refreshToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader){
//        return service.refreshToken(authHeader);
//    }
//
//}
