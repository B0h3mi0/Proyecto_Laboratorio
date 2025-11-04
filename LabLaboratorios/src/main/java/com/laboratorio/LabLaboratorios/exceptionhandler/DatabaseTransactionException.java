package com.laboratorio.LabLaboratorios.exceptionhandler;

public class DatabaseTransactionException extends RuntimeException {

    public DatabaseTransactionException(String message, Throwable cause) {
        super(message);
        super.initCause(cause);
    }
}
