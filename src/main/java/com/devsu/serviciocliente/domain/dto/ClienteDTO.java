package com.devsu.serviciocliente.domain.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO extends PersonaDTO {

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 2, max = 12, message = "el tamaño debe de estar entre 2 y 12")
    @Column(nullable = false)
    private String contrasena;

    private Boolean estado;
}
