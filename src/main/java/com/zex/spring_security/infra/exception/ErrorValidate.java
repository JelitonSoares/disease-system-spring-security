package com.zex.spring_security.infra.exception;

import org.springframework.validation.FieldError;

public record ErrorValidate(String field, String message) {


    public ErrorValidate(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
