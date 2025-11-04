package com.laboratorio.LabUsuarios.repository;

import com.laboratorio.LabUsuarios.model.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository <TokenEntity, Long>{
}
