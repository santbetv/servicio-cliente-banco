package com.devsu.serviciocliente.domain.port.out.db;

import com.devsu.serviciocliente.application.dto.ClienteDTO;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.Cliente;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleException;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleValidationException;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Santiago Betancur
 */
public interface IClienteService {

    public Cliente findById(Long id) throws BussinesRuleException;

    public List<Cliente> findAll();

    public Cliente save(ClienteDTO clienteDTO, BindingResult result) throws BussinesRuleValidationException;

    public void put(ClienteDTO clienteDTO, BindingResult result, Long id) throws BussinesRuleException, BussinesRuleValidationException;

    public void delete(Long id) throws BussinesRuleException;
}
