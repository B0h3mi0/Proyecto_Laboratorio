package com.laboratorio.LabLaboratorios.controller;

import com.laboratorio.LabLaboratorios.api.request.LaboratorioUpdateRequest;
import com.laboratorio.LabLaboratorios.model.LaboratorioEntity;
import com.laboratorio.LabLaboratorios.service.LaboratorioService;
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
@RequestMapping("/laboratorios")
public class LaboratoriosController {
    private static final Logger logger = LoggerFactory.getLogger(LaboratoriosController.class);

    @Autowired
    private LaboratorioService laboratorioService;
    
    @GetMapping("/all")
    public ResponseEntity<List<LaboratorioEntity>> getAllLaboratorios() {
        logger.info("Obteninendo todos los Laboratorios");
        List<LaboratorioEntity> laboratorios = laboratorioService.getAllLaboratorios();
        logger.info("Laboratorios Obtenidos {} ", laboratorios.size());
        return new ResponseEntity<>(laboratorios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioEntity> getLaboratorioById(@PathVariable Long id) {
        logger.info("Obteniendo Laboratorio by ID: {}", id);
        Optional<LaboratorioEntity> Laboratorio = laboratorioService.getLaboratorioById(id);
        return Laboratorio.map(value -> {
                    logger.info("Laboratorio encontrado by ID: {}", id);
                    return new ResponseEntity<>(value, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    logger.info("Laboratorio no encontrado by ID: {}", id);
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    @PostMapping()
    public ResponseEntity<LaboratorioEntity> creaLaboratorio(@RequestBody LaboratorioEntity Laboratorio) {
        logger.info("Creando un nuevo Laboratorio con request: {}", Laboratorio);
        LaboratorioEntity savedLaboratorio = laboratorioService.createLaboratorio(Laboratorio);
        logger.info("Laboratorio creado satisfactoriamente. Laboratorio ID: {}", savedLaboratorio.getId());
        return new ResponseEntity<>(savedLaboratorio, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LaboratorioEntity> patchLaboratorio(@PathVariable Long id, @RequestBody LaboratorioUpdateRequest updateRequest) {
        logger.info("Actualizando Laboratorio con ID: {} and request: {}", id, updateRequest);
        LaboratorioEntity updatedLaboratorio = laboratorioService.updateLaboratorio(id, updateRequest);
        logger.info("Laboratorio actualizado satisfactoriamente. Laboratorio ID: {}", updatedLaboratorio.getId());
        return new ResponseEntity<>(updatedLaboratorio, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaboratorio(@PathVariable Long id){
        logger.info("Eliminando Laboratorio con ID: {}", id);
        laboratorioService.deleteLaboratorioById(id);
        logger.info("Laboratorio eliminado satisfactoriamente. Laboratorio ID: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
