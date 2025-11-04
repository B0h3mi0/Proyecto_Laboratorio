package com.laboratorio.LabUsuarios.api.request;

public record RegisterRequest (
        String correo,
        String contrasena,
        String nomUsuario,
        String apUsuario,
        String rol
)
{ }
