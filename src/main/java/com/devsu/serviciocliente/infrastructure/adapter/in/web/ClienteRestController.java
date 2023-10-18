package com.devsu.serviciocliente.infrastructure.adapter.in.web;


import com.devsu.serviciocliente.domain.port.in.web.WebPort;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.Cliente;
import com.devsu.serviciocliente.domain.port.out.db.IClienteService;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.Persona;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santiago Betancur
 */
@Tag(name = "ClienteRestController API", description = "This API service all funcionality for management ClienteRestController")
@RestController
@RequestMapping("/api")
public class ClienteRestController implements WebPort{

    private static final Logger LOG = LoggerFactory.getLogger(ClienteRestController.class);

    private final IClienteService iClienteService;

    @Autowired
    public ClienteRestController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    @Override
    @GetMapping("/clientes/{id}")
    public Cliente get(Long id) {
        return iClienteService.findById(id);
    }

    @Override
    @GetMapping("/clientes")
    public List<Cliente> findAll() {
        return iClienteService.findAll();
    }

    @Override
    @PostMapping("/clientes")
    public ResponseEntity<?> post(Cliente input) {
        Persona save = iClienteService.save(input);
        return ResponseEntity.ok(save);
    }
}
