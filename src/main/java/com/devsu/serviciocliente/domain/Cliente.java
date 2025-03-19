/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devsu.serviciocliente.domain;

import lombok.*;

/**
 * @author rizzoli
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Persona {
    private Long idCliente;
    private String contrasena;
    private Boolean estado;

    public Cliente(String contrasena) {
        this.contrasena = contrasena;
    }

    public void activarCuenta() {
        if (Boolean.TRUE.equals(this.estado)) {
            throw new IllegalStateException("La cuenta ya se encuentra activa.");
        }
        this.estado = true;
    }

    public boolean esContrasenaSegura() {
        if (contrasena == null) {
            return false;
        }
        return contrasena.length() >= 8 &&
                contrasena.matches(".*[A-Z].*") &&
                contrasena.matches(".*\\d.*");
    }
}
