package com.atl.academy.productms.exception;

import com.atl.academy.productms.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception ex) {
        log.error("Exception ", ex);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleException(ProductNotFoundException ex) {
        log.error("ProductNotFoundException ", ex);
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getCode(), ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(value = ProductNotLeftException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse handleException(ProductNotLeftException ex) {
        log.error("ProductNotLeftException ", ex);
        return new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), ex.getCode(), ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(value = ProductAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleException(ProductAlreadyExistsException ex) {
        log.error("ProductAlreadyExistsException ", ex);
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getCode(), ex.getMessage(), LocalDateTime.now());
    }
}
