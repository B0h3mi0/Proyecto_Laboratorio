package com.laboratorio.LabUsuarios.api.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioUpdateRequest {

    // Nombre de usuario
    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre de usuario debe tener entre 2 y 50 caracteres")
    private String nomUsuario;

    // Apellido
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apUsuario;

    // Correo electrónico
    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "Debe ingresar un correo electrónico válido")
    private String correo;

    // Teléfono
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "El teléfono debe contener solo números y puede incluir un '+' al inicio")
    private String telefono;

    // Contraseña
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String contrasena;

    // Rol de usuario
    @NotNull(message = "El rol no puede ser nulo")
    @Pattern(
            regexp = "^(ADMIN|LABORATORIO|CLIENTE)$",
            message = "El rol debe ser ADMIN, LABORATORIO o CLIENTE"
    )
    private String rol;
}

