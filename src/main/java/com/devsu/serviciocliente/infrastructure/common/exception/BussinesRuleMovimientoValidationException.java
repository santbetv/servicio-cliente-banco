package com.devsu.serviciocliente.infrastructure.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Santiago Betancur
 */
@Getter
@Setter
public class BussinesRuleMovimientoValidationException extends Exception {

    private long id;
    private String code;
    private HttpStatus httpStatus;
    private String type;

    public BussinesRuleMovimientoValidationException(long id, String code, String message, HttpStatus httpStatus, String type) {
        super(message);
        this.id = id;
        this.code = code;
        this.httpStatus = httpStatus;
        this.type = type;
    }

    public BussinesRuleMovimientoValidationException(String type, String code) {
        this.code = code;
        this.type = type;
    }

    public BussinesRuleMovimientoValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
