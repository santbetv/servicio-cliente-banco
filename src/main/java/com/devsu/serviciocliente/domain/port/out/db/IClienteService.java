package com.devsu.serviciocliente.domain.port.out.db;

import com.devsu.serviciocliente.application.dto.ClienteDTO;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.ClienteEntity;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleException;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleValidationException;
import java.util.List;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Santiago Betancur
 */
public interface IClienteService {

    public ClienteEntity findById(Long id) throws BussinesRuleException;

    public List<ClienteEntity> findAll();

    public ClienteEntity save(ClienteDTO clienteDTO, BindingResult result) throws BussinesRuleValidationException;

    public void put(ClienteDTO clienteDTO, BindingResult result, Long id) throws BussinesRuleException, BussinesRuleValidationException;

    public void delete(Long id) throws BussinesRuleException;
}
