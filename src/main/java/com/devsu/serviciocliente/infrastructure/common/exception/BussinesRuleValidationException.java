package com.devsu.serviciocliente.infrastructure.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Santiago Betancur
 */
@Getter
@Setter
public class BussinesRuleValidationException extends Exception {

    private long id;
    private String code;
    private HttpStatus httpStatus;
    private String type;
    private BindingResult result;

    public BussinesRuleValidationException(long id, String code, String message, HttpStatus httpStatus, String type) {
        super(message);
        this.id = id;
        this.code = code;
        this.httpStatus = httpStatus;
        this.type = type;
    }

    public BussinesRuleValidationException(String type, BindingResult result) {
        this.type = type;
        this.result = result;
    }
    
    public BussinesRuleValidationException(String type, String result) {
        this.type = type;
        this.code = result;
    }

    public BussinesRuleValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
