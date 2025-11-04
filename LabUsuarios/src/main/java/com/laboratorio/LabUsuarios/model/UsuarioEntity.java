package com.laboratorio.LabUsuarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Nombre de usuario
    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre de usuario debe tener entre 2 y 50 caracteres")
    @Column(name = "nom_usuario", nullable = false, length = 50)
    private String nomUsuario;

    // Apellido
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Column(name = "ap_usuario", nullable = false, length = 50)
    private String apUsuario;

    // Correo electrónico
    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "Debe ingresar un correo electrónico válido")
    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    // Teléfono
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "El teléfono debe contener solo números y puede incluir un '+' al inicio")
    @Column(name = "telefono", length = 15)
    private String telefono;

    // Contraseña
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Column(name = "contraseña", nullable = false)
    private String contrasena;

    // Rol de usuario
    @NotNull(message = "El rol no puede ser nulo")
    @Pattern(
            regexp = "^(ADMIN|LABORATORIO|CLIENTE)$",
            message = "El rol debe ser ADMIN, LABORATORIO o CLIENTE"
    )
    @Column(name = "rol", nullable = false, length = 20)
    private String rol;

//    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
//    private List<TokenEntity> tokens;
}