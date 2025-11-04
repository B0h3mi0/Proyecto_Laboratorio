package com.laboratorio.LabLaboratorios.api.request;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LaboratorioUpdateRequest {

    // Nombre del Laboratorio
    @NotBlank(message = "El nombre del Laboratorio no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre del Laboratorio debe tener entre 2 y 50 caracteres")
    private String nomLaboratorio;


    // Direccion
    @NotBlank(message = "La direccion no puede estar vacío")
    @Size(min = 2, max = 150, message = "La direccion del Laboratorio debe tener entre 2 y 150 caracteres")
    private String direccion;

    // Teléfono
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "El teléfono debe contener solo números y puede incluir un '+' al inicio")
    private String telefono;

    // Tipo Analisis
    @NotNull(message = "El tipo de analisis no puede estar vacio")
    @Size(min = 2, max = 150, message = "El tipo de analisis debe tener entre 2 y 150 caracteres")
    private String tipoAnalisis;
}

