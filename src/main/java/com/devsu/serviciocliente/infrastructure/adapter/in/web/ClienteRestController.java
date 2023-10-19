package com.devsu.serviciocliente.infrastructure.adapter.in.web;

import com.devsu.serviciocliente.application.dto.ClienteDTO;
import com.devsu.serviciocliente.domain.port.in.web.WebPort;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.Cliente;
import com.devsu.serviciocliente.domain.port.out.db.IClienteService;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.Persona;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleException;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleValidationException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santiago Betancur
 */
@Tag(name = "ClienteRestController API", description = "This API service all funcionality for management ClienteRestController")
@RestController
@RequestMapping("/api")
public class ClienteRestController implements WebPort {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteRestController.class);

    private final IClienteService iClienteService;

    @Autowired
    public ClienteRestController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    @Override
    @GetMapping("/clientes/{id}")
    public Cliente get(@PathVariable Long id) throws BussinesRuleException {
        return iClienteService.findById(id);
    }

    @Override
    @GetMapping("/clientes")
    public List<Cliente> findAll() {
        return iClienteService.findAll();
    }

    @Override
    @PostMapping("/clientes")
    public ResponseEntity<?> post(@Valid @RequestBody ClienteDTO input, BindingResult result) throws BussinesRuleValidationException {
        Persona save = iClienteService.save(input, result);
        return ResponseEntity.ok(save);
    }

    @Override
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws BussinesRuleException {
        iClienteService.delete(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @Override
    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> put(@Valid
            @RequestBody ClienteDTO input, BindingResult result,
            @PathVariable Long id) throws BussinesRuleException, BussinesRuleValidationException {
        iClienteService.put(input, result, id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
