package com.example.tprest.service.exception;
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
