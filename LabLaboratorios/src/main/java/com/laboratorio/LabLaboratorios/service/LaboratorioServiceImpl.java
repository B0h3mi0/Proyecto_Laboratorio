package com.laboratorio.LabLaboratorios.service;

import com.laboratorio.LabLaboratorios.api.request.LaboratorioUpdateRequest;
import com.laboratorio.LabLaboratorios.exceptionhandler.DatabaseTransactionException;
import com.laboratorio.LabLaboratorios.exceptionhandler.ResourceNotFoundException;
import com.laboratorio.LabLaboratorios.model.LaboratorioEntity;
import com.laboratorio.LabLaboratorios.repository.LaboratorioRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LaboratorioServiceImpl implements LaboratorioService {
    @Autowired
    private LaboratorioRepository laboratorioRepository;
    private static final Logger logger = LoggerFactory.getLogger(LaboratorioServiceImpl.class);

    @Override
    public List<LaboratorioEntity> getAllLaboratorios(){
        logger.info("Buscando todos los laboratorios - metodo getAllLaboratorios");
        return laboratorioRepository.findAll();
    }

    @Override
    public Optional<LaboratorioEntity> getLaboratorioById(Long id) {
        logger.info("Buscando Laboratorio por ID {} - metodo getLaboratorioById", id);
        return laboratorioRepository.findById(id);
    }

    @Override
    public LaboratorioEntity createLaboratorio(LaboratorioEntity laboratorioToSave) {
        logger.info("Creando Laboratorio con request: {} - Metodo saveLaboratorio", laboratorioToSave);
        try{
            LaboratorioEntity savedLaboratorio = laboratorioRepository.save(laboratorioToSave);
            logger.info("Laboratorio creado satisfactoriamente. Laboratorio ID: {} - metodo createLaboratorio",savedLaboratorio.getId());
            return savedLaboratorio;
        } catch (Exception e) {
            logger.error("Error creando Laboratorio - metodo createLaboratorio");
            throw new DatabaseTransactionException("Error creando Laboratorio", e);
        }
    }

    @Override
    public LaboratorioEntity updateLaboratorio(Long id, LaboratorioUpdateRequest updateRequest) {
        logger.info("Actualizando laboratorio con ID: {} y request: {} - metodo updateLaboratorio", id, updateRequest);

        // Buscar el laboratorio en la base de datos
        LaboratorioEntity laboratorio = laboratorioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Laboratorio no encontrado con ID: " + id));

        // Actualizar solo los campos que vengan en el request
        if (updateRequest.getNomLaboratorio() != null) {
            logger.info("Actualizando nomLaboratorio to: {} - metodo updateLaboratorio", updateRequest.getNomLaboratorio());
            laboratorio.setNomLaboratorio(updateRequest.getNomLaboratorio());
        }
        if (updateRequest.getDireccion() != null) {
            logger.info("Actualizando Direccion : {} - metodo updateLaboratorio", updateRequest.getDireccion());
            laboratorio.setDireccion(updateRequest.getDireccion());
        }
        if (updateRequest.getTelefono() != null) {
            logger.info("Actualizando correo : {} - metodo updateLaboratorio", updateRequest.getTelefono());
            laboratorio.setTelefono(updateRequest.getTelefono());
        }
        if (updateRequest.getTipoAnalisis() != null) {
            logger.info("Actualizando rol : {} - method updateLaboratorio", updateRequest.getTipoAnalisis());
            laboratorio.setTipoAnalisis(updateRequest.getTipoAnalisis());
        }
        // Guardar los cambios
        logger.info("Guardando laboratorio - metodo updateLaboratorio");
        LaboratorioEntity updatedLaboratorio = laboratorioRepository.save(laboratorio);
        logger.info("Laboratorio updated successfully. Laboratorio ID: {}", updatedLaboratorio.getId());

        return updatedLaboratorio;
    }

    @Override
    public void deleteLaboratorioById(Long id) {
        logger.info("Eliminando Laboratorio por ID : {} - metodo deleteLaboratorioById", id);
        Optional<LaboratorioEntity> laboratorio = laboratorioRepository.findById(id);
        if (laboratorio.isEmpty()) {
            logger.info("Laboratorio id {} no encontrado - metodo deleteLaboratorioById", id);
            throw new ResourceNotFoundException("Laboratorio NO ENCONTRADO");
        }
        logger.info("Eliminando Laboratorio - metodo deleteLaboratorioById" );
        logger.info("Id Laboratorio {} - metodo deleteLaboratorioById" , id);
        laboratorioRepository.deleteById(id);
        logger.info("Laboratorio eliminado satisfactoriamente - metodo deleteLaboratorioById");

    }
}
