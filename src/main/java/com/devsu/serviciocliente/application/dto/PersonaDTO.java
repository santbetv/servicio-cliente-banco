package com.devsu.serviciocliente.application.dto;

import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDTO {
	
	@NotEmpty(message = "no puede estar vacio")
	private String nombre;
	@NotEmpty(message = "no puede estar vacio")
	private String genero;
	@NotEmpty(message = "no puede estar vacio")
	private String edad;
	@NotEmpty(message = "no puede estar vacio")
	private String identificacion;
	private String direccion;
	private String telefono;	
}
