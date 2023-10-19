package com.devsu.serviciocliente.infrastructure.common.exception;

import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Indico que esta clase es la axiliar de controller
public class ApiExceptionHandler {

    private static final String CODIGO_ERROR = "001";
    private static final String CODIGO_ERROR_VALIDATION = "002";
    private static final String ERROR_VALIDACION = "Error de validación";
    private static final String ERROR_VALIDACION_NO_EXISTE = "Error de validación, cliente no existe";

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<ApiExeceptionResponse> handleUnknownHostException(UnknownHostException ex) {
        ApiExeceptionResponse response = new ApiExeceptionResponse("", "Error de conexion", "erorr-1024", ex.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {      
        ApiExeceptionResponse response = new ApiExeceptionResponse(ex.getLocalizedMessage(), ERROR_VALIDACION, CODIGO_ERROR,"Error en la base de datos: Violación de restricción de columna única.");
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BussinesRuleException.class)
    public ResponseEntity<ApiExeceptionResponse> handleBussinesRuleException(BussinesRuleException ex) {
        ApiExeceptionResponse response = new ApiExeceptionResponse(ex.getType(), ERROR_VALIDACION, CODIGO_ERROR,ERROR_VALIDACION_NO_EXISTE);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BussinesRuleMovimientoValidationException.class)
    public ResponseEntity<ApiExeceptionResponse> handleBussinesRuleException(BussinesRuleMovimientoValidationException ex) {
        ApiExeceptionResponse response = new ApiExeceptionResponse(ex.getType(), ERROR_VALIDACION, ex.getCode(),
                ERROR_VALIDACION_NO_EXISTE);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BussinesRuleValidationException.class)
    public ResponseEntity<ApiExeceptionResponse> handleBussinesRuleValidationException(BussinesRuleValidationException ex) {

        List<String> errors = ex.getResult().getFieldErrors().stream()
                .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                .collect(Collectors.toList());

        ApiExeceptionResponse response = new ApiExeceptionResponse(ex.getType(), ERROR_VALIDACION, CODIGO_ERROR_VALIDATION,
                errors.toString());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
