package com.laboratorio.LabUsuarios.api.request;

public record LoginRequest(
        String correo,
        String constrasena,
        String nomUsuario,
        String apUsuario,
        String rol
)
{
}