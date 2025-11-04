package com.laboratorio.LabLaboratorios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "laboratorio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LaboratorioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Nombre del Laboratorio
    @NotBlank(message = "El nombre del Laboratorio no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre del Laboratorio debe tener entre 2 y 50 caracteres")
    @Column(name = "nom_laboratorio", nullable = false, length = 50)
    private String nomLaboratorio;


    // Direccion
    @NotBlank(message = "La direccion no puede estar vacío")
    @Size(min = 2, max = 150, message = "La direccion del Laboratorio debe tener entre 2 y 150 caracteres")
    @Column(name = "direccion", nullable = false, length = 150)
    private String direccion;

    // Teléfono
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "El teléfono debe contener solo números y puede incluir un '+' al inicio")
    @Column(name = "telefono", length = 15)
    private String telefono;

    // Tipo Analisis
    @NotNull(message = "El tipo de analisis no puede estar vacio")
    @Size(min = 2, max = 150, message = "El tipo de analisis debe tener entre 2 y 150 caracteres")
    @Column(name = "tipo_analisis", nullable = false, length = 150)
    private String tipoAnalisis;
}