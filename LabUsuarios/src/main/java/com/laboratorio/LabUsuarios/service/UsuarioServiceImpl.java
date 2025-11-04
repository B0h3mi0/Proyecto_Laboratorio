package com.laboratorio.LabUsuarios.service;

import com.laboratorio.LabUsuarios.api.request.UsuarioUpdateRequest;
import com.laboratorio.LabUsuarios.controller.UsuarioController;
import com.laboratorio.LabUsuarios.exceptionhandler.DatabaseTransactionException;
import com.laboratorio.LabUsuarios.exceptionhandler.ResourceNotFoundException;
import com.laboratorio.LabUsuarios.model.UsuarioEntity;
import com.laboratorio.LabUsuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Override
    public List<UsuarioEntity> getAllUsuarios(){
        logger.info("Buscando todos los usuarios - metodo getAllUsuarios");
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioEntity> getUsuarioById(Long id) {
        logger.info("Buscando Usuario por ID {} - metodo getUsuarioById", id);
        return usuarioRepository.findById(id);
    }

    @Override
    public UsuarioEntity createUsuario(UsuarioEntity usuarioToSave) {
        logger.info("Creando Usuario con request: {} - Metodo saveUsuario", usuarioToSave);
        try{
            UsuarioEntity savedUsuario = usuarioRepository.save(usuarioToSave);
            logger.info("Usuario creado satisfactoriamente. Usuario ID: {} - metodo createUsuario",savedUsuario.getId());
            return savedUsuario;
        } catch (Exception e) {
            logger.error("Error creando Usuario - metodo createUsuario");
            throw new DatabaseTransactionException("Error creando Usuario", e);
        }
    }

    @Override
    public UsuarioEntity updateUsuario(Long id, UsuarioUpdateRequest updateRequest) {
        logger.info("Actualizando usuario con ID: {} y request: {} - metodo updateUsuario", id, updateRequest);

        // Buscar el usuario en la base de datos
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));

        // Actualizar solo los campos que vengan en el request
        if (updateRequest.getNomUsuario() != null) {
            logger.info("Actualizando nomUsuario to: {} - metodo updateUsuario", updateRequest.getNomUsuario());
            usuario.setNomUsuario(updateRequest.getNomUsuario());
        }
        if (updateRequest.getApUsuario() != null) {
            logger.info("Actualizando apUsuario : {} - metodo updateUsuario", updateRequest.getApUsuario());
            usuario.setApUsuario(updateRequest.getApUsuario());
        }
        if (updateRequest.getCorreo() != null) {
            logger.info("Actualizando correo : {} - metodo updateUsuario", updateRequest.getCorreo());
            usuario.setCorreo(updateRequest.getCorreo());
        }
        if (updateRequest.getTelefono() != null) {
            logger.info("Actualizando telefono : {} - metodo updateUsuario", updateRequest.getTelefono());
            usuario.setTelefono(updateRequest.getTelefono());
        }
        if (updateRequest.getContrasena() != null) {
            logger.info("Actualizando contrasena - metodo updateUsuario");
            usuario.setContrasena(updateRequest.getContrasena());
        }
        if (updateRequest.getRol() != null) {
            logger.info("Actualizando rol : {} - method updateUsuario", updateRequest.getRol());
            usuario.setRol(updateRequest.getRol());
        }
        // Guardar los cambios
        logger.info("Guardando usuario - metodo updateUsuario");
        UsuarioEntity updatedUsuario = usuarioRepository.save(usuario);
        logger.info("Usuario updated successfully. Usuario ID: {}", updatedUsuario.getId());

        return updatedUsuario;
    }

    @Override
    public void deleteUsuarioById(Long id) {
        logger.info("Eliminando Usuario por ID : {} - metodo deleteUsuarioById", id);
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            logger.info("Usuario id {} no encontrado - metodo deleteUsuarioById", id);
            throw new ResourceNotFoundException("Usuario NO ENCONTRADO");
        }
        logger.info("Eliminando Usuario - metodo deleteUsuarioById" );
        logger.info("Id Usuario {} - metodo deleteUsuarioById" , id);
        usuarioRepository.deleteById(id);
        logger.info("Usuario eliminado satisfactoriamente - metodo deleteUsuarioById");

    }
}
