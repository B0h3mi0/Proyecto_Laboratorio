package com.laboratorio.LabUsuarios.service;

import com.laboratorio.LabUsuarios.api.request.UsuarioUpdateRequest;
import com.laboratorio.LabUsuarios.model.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioEntity> getAllUsuarios();
    Optional<UsuarioEntity> getUsuarioById(Long id);
    UsuarioEntity createUsuario(UsuarioEntity usuario);
    UsuarioEntity updateUsuario(Long id, UsuarioUpdateRequest updateRequest);
    void deleteUsuarioById (Long id);
}
