package com.laboratorio.LabLaboratorios.repository;

import com.laboratorio.LabLaboratorios.model.LaboratorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratorioRepository extends JpaRepository <LaboratorioEntity, Long> {
}
