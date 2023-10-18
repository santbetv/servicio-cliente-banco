/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devsu.serviciocliente.domain.port.in.web;

import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.Cliente;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author rizzoli
 */
public interface WebPort {
    
    @GetMapping("/clientes/{id}")
    Cliente get(@PathVariable Long id);
    
    @GetMapping("/clientes")
    List<Cliente> findAll();
    
    @PostMapping("/clientes")
    ResponseEntity<?> post(@RequestBody Cliente input);
    
}
