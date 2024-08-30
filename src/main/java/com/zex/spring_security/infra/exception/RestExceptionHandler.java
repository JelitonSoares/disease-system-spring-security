package com.zex.spring_security.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionMessage> exceptionHandler(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionMessage(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<ExceptionMessage> badCredentialsHandler(BadCredentialsException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ExceptionMessage(exception.getMessage(), HttpStatus.UNAUTHORIZED));
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ExceptionMessage> accessDeniedHandler(AccessDeniedException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ExceptionMessage(exception.getMessage(), HttpStatus.FORBIDDEN));
    }

    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity<ExceptionMessage> authenticationHandler(AuthenticationException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ExceptionMessage(exception.getMessage(), HttpStatus.UNAUTHORIZED));
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionMessage> httpMessageNotReadableHandler(HttpMessageNotReadableException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionMessage(exception.getMessage(), HttpStatus.BAD_REQUEST));
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorValidate>> methodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        List<FieldError> erros = exception.getFieldErrors();

        List<ErrorValidate> errorValidates = erros.stream()
                .map(erro -> new ErrorValidate(erro.getField(), erro.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorValidates);

    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ExceptionMessage> entityNotFoundHandler(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionMessage(exception.getMessage(), HttpStatus.NOT_FOUND));
    }





}
