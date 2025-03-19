package com.devsu.serviciocliente.infrastructure.adapter.in.web;

import com.devsu.serviciocliente.domain.dto.ClienteDTO;
import com.devsu.serviciocliente.application.port.in.mapper.ClienteResponseMapper;
import com.devsu.serviciocliente.application.port.in.web.WebPort;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.ClienteEntity;
import com.devsu.serviciocliente.application.port.out.db.ClienteService;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.PersonaEntity;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleException;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleValidationException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author Santiago Betancur
 */
@Tag(name = "ClienteRestController API", description = "This API service all funcionality for management ClienteRestController")
@RestController
@RequestMapping("/api")
public class ClienteRestController implements WebPort {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteRestController.class);

    private final ClienteService clienteService;
    private final ClienteResponseMapper clienteResponseMapper;

    @Autowired
    public ClienteRestController(ClienteService clienteService, ClienteResponseMapper clienteResponseMapper) {
        this.clienteService = clienteService;
        this.clienteResponseMapper = clienteResponseMapper;
    }

    @Override
    @GetMapping("/clientes/{id}")
    public ClienteDTO get(@PathVariable Long id) throws BussinesRuleException {
        return clienteResponseMapper.toClienteDTORequest(clienteService.findById(id));
    }

    @Override
    @GetMapping("/clientes")
    public List<ClienteDTO> findAll() {
        List<ClienteEntity> clienteEntities = clienteService.findAll();
        return clienteResponseMapper.toListClienteDTORequest(clienteEntities);
    }

    @GetMapping("/clientes2")
    public ResponseEntity<List<ClienteDTO>> findAll2() {
        List<ClienteEntity> clienteEntitys = clienteService.findAll();
        if (clienteEntitys == null || clienteEntitys.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            List<ClienteDTO> data = clienteResponseMapper.toListClienteDTORequest(clienteEntitys);
            return ResponseEntity.ok(data);
        }
    }

    @Override
    @PostMapping("/clientes")
    public ResponseEntity<?> post(@Valid @RequestBody ClienteDTO input, BindingResult result) throws BussinesRuleValidationException {
        PersonaEntity save = clienteService.save(input, result);
        return ResponseEntity.ok(save);
    }

    @Override
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws BussinesRuleException {
        clienteService.delete(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @Override
    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> put(@Valid
                                 @RequestBody ClienteDTO input, BindingResult result,
                                 @PathVariable Long id) throws BussinesRuleException, BussinesRuleValidationException {
        clienteService.put(input, result, id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
