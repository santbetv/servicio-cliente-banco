package com.devsu.serviciocliente.domain.port.out.db;

import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.Cliente;
import java.util.List;

/**
 *
 * @author Santiago Betancur
 */
public interface IClienteService {

    public Cliente findById(Long id);

    public List<Cliente> findAll();

    public Cliente save(Cliente cliente);
}
