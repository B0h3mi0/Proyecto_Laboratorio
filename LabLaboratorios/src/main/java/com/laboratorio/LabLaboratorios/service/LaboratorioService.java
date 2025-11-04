package com.laboratorio.LabLaboratorios.service;

import com.laboratorio.LabLaboratorios.api.request.LaboratorioUpdateRequest;
import com.laboratorio.LabLaboratorios.model.LaboratorioEntity;

import java.util.List;
import java.util.Optional;

public interface LaboratorioService {
    List<LaboratorioEntity> getAllLaboratorios();
    Optional<LaboratorioEntity> getLaboratorioById(Long id);
    LaboratorioEntity createLaboratorio(LaboratorioEntity Laboratorio);
    LaboratorioEntity updateLaboratorio(Long id, LaboratorioUpdateRequest updateRequest);
    void deleteLaboratorioById (Long id);
}
