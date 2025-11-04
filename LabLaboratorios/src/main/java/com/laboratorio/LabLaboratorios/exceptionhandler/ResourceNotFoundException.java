package com.laboratorio.LabLaboratorios.exceptionhandler;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
