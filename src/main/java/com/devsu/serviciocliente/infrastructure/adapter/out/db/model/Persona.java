package com.devsu.serviciocliente.infrastructure.adapter.out.db.model;

import jakarta.persistence.Column;
import java.io.Serializable;

import jakarta.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Persona implements Serializable  {
	
	private String nombre;
	private String genero;
	private String edad;
        @Column(unique = true)
	private String identificacion;
	private String direccion;
	private String telefono;
	
	private static final long serialVersionUID = -4658598829300825501L;
	
}
