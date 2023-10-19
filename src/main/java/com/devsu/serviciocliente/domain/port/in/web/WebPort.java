/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devsu.serviciocliente.domain.port.in.web;

import com.devsu.serviciocliente.application.dto.ClienteDTO;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.Cliente;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleException;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleValidationException;
import jakarta.validation.Valid;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author rizzoli
 */
public interface WebPort {
   
    @GetMapping("/clientes/{id}")
    public Cliente get(@PathVariable Long id) throws BussinesRuleException;

    @GetMapping("/clientes")
    public List<Cliente> findAll();

    @PostMapping("/clientes")
    public ResponseEntity<?> post(@Valid @RequestBody ClienteDTO input, BindingResult result) throws  BussinesRuleValidationException;

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws BussinesRuleException;

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> put(@Valid @RequestBody ClienteDTO input, BindingResult result, @PathVariable Long id) throws BussinesRuleException, BussinesRuleValidationException;
    
}
