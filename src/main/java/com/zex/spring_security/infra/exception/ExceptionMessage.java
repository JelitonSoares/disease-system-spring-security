package com.zex.spring_security.infra.exception;

import org.springframework.http.HttpStatus;

public record ExceptionMessage(String message, HttpStatus status) {
}
