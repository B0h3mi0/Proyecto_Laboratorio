package com.laboratorio.LabUsuarios.controller;

import com.laboratorio.LabUsuarios.api.request.UsuarioUpdateRequest;
import com.laboratorio.LabUsuarios.model.UsuarioEntity;
import com.laboratorio.LabUsuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/all")
    public ResponseEntity<List<UsuarioEntity>> getAllUsuarios() {
        logger.info("Obteninendo todos los Usuarios");
        List<UsuarioEntity> usuarios = usuarioService.getAllUsuarios();
        logger.info("Usuarios Obtenidos {} ", usuarios.size());
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> getUsuarioById(@PathVariable Long id) {
        logger.info("Obteniendo a Usuario by ID: {}", id);
        Optional<UsuarioEntity> Usuario = usuarioService.getUsuarioById(id);
        return Usuario.map(value -> {
                    logger.info("Usuario encontrado by ID: {}", id);
                    return new ResponseEntity<>(value, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    logger.info("Usuario no encontrado by ID: {}", id);
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    @PostMapping()
    public ResponseEntity<UsuarioEntity> creaUsuario(@RequestBody UsuarioEntity Usuario) {
        logger.info("Creando un nuevo Usuario con request: {}", Usuario);
        UsuarioEntity savedUsuario = usuarioService.createUsuario(Usuario);
        logger.info("Usuario creado satisfactoriamente. Usuario ID: {}", savedUsuario.getId());
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioEntity> patchUsuario(@PathVariable Long id, @RequestBody UsuarioUpdateRequest updateRequest) {
        logger.info("Actualizando Usuario con ID: {} and request: {}", id, updateRequest);
        UsuarioEntity updatedUsuario = usuarioService.updateUsuario(id, updateRequest);
        logger.info("Usuario actualizado satisfactoriamente. Usuario ID: {}", updatedUsuario.getId());
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        logger.info("Eliminando Usuario con ID: {}", id);
        usuarioService.deleteUsuarioById(id);
        logger.info("Usuario eliminado satisfactoriamente. Usuario ID: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
