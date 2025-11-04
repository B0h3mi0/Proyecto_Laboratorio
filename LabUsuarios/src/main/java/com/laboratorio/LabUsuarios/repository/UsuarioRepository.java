package com.laboratorio.LabUsuarios.repository;

import com.laboratorio.LabUsuarios.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long> {
}
