package com.devsu.serviciocliente.infrastructure.common.exception;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Santiago Betancur
 */

@Getter
@Setter
public class ApiExeceptionResponse {
	//@ApiModelProperty(notes = "The unique uri identifier that categorizes the error", name = "type", required = true, example = "/errors/authentication/not-authorized")
	private String type = "/errors/uncategorized";
	
	//@ApiModelProperty(notes = "A brief, human-readable message about the error", name = "title", required = true, example = "The user does not have autorization")
	private String title;
	
	//@ApiModelProperty(notes = "The unique error code", name = "code", required = false, example = "192")
	private String code;
	
	//@ApiModelProperty(notes = "A human-readable explanation of the error", name = "detail", required = true, example = "The user does not have the propertly persmissions to acces the "
	//		+ "resource, please contact with ass https://prueba.com")
	private String detail;
	
	//@ApiModelProperty(notes = "A URI that identifies the specific occurrence of the error", name = "detail", required = true, example = "/errors/authentication/not-authorized/01")
	private String instance = "/errors/uncategorized/banco";

	public ApiExeceptionResponse(String type, String title, String code, String detail) {
		this.type = type;
		this.title = title;
		this.code = code;
		this.detail = detail;
	}

}
