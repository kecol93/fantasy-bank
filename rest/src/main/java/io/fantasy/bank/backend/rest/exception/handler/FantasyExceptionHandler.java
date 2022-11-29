package io.fantasy.bank.backend.rest.exception.handler;

import io.fantasy.bank.backend.common.exception.FantasyException;
import io.fantasy.bank.backend.common.exception.type.FantasyErrorType;
import io.fantasy.bank.backend.rest.exception.model.FantasyError;
import io.fantasy.bank.backend.rest.exception.utility.Helper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice()
public class FantasyExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        FantasyError fantasyError = Helper.mapToFantasyError(FantasyErrorType.FB_001, request);
        return handleExceptionInternal(ex, fantasyError,
                new HttpHeaders(), fantasyError.getStatus(), request);
    }

    @ExceptionHandler(value
            = {FantasyException.class})
    protected ResponseEntity<Object> handleFantasyException(
            FantasyException ex, WebRequest request) {
        FantasyError fantasyError = Helper.mapToFantasyError(ex.getFantasyErrorType(), request);
        return handleExceptionInternal(ex, fantasyError,
                new HttpHeaders(), fantasyError.getStatus(), request);
    }

    @ExceptionHandler(value
            = {Exception.class})
    protected ResponseEntity<Object> handleGenericException(
            Exception ex, WebRequest request) {
        FantasyError fantasyError = Helper.mapToFantasyError(FantasyErrorType.FB_599, request);
        return handleExceptionInternal(ex, fantasyError,
                new HttpHeaders(), fantasyError.getStatus(), request);
    }
}