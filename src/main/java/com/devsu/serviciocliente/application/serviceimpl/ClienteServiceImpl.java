package com.devsu.serviciocliente.application.serviceimpl;

import com.devsu.serviciocliente.application.dto.ClienteDTO;
import com.devsu.serviciocliente.infrastructure.adapter.out.notification.Publisher;
import com.devsu.serviciocliente.domain.port.out.db.IClienteService;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.repository.ClienteRepository;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.ClienteEntity;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleException;
import com.devsu.serviciocliente.infrastructure.common.exception.BussinesRuleValidationException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Santiago Betancur
 */
@Service
public class ClienteServiceImpl implements IClienteService {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteServiceImpl.class);

    private final String INFO_URL = "api/cliente";

    private final ClienteRepository clienteRepository;
    private Publisher publisher;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, Publisher publisher) {
        this.clienteRepository = clienteRepository;
        this.publisher = publisher;
    }

    @Override
    @Transactional(readOnly = true) //
    public ClienteEntity findById(Long id) throws BussinesRuleException {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        if (!cliente.isEmpty()) {
            return clienteRepository.findById(id).get();
        } else {
            BussinesRuleException exception = new BussinesRuleException(INFO_URL);
            throw exception;
        }
    }

    @Override
    @Transactional(readOnly = true) //
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional() //
    public ClienteEntity save(ClienteDTO clienteDTO, BindingResult result) throws BussinesRuleValidationException {

        if (result.hasErrors()) {
            BussinesRuleValidationException exception = new BussinesRuleValidationException(INFO_URL, result);
            throw exception;
        } else {
            ClienteEntity c = new ClienteEntity();
            c.setNombre(clienteDTO.getNombre());
            c.setGenero(clienteDTO.getGenero());
            c.setEdad(clienteDTO.getEdad());
            c.setIdentificacion(clienteDTO.getIdentificacion());
            c.setDireccion(clienteDTO.getDireccion());
            c.setTelefono(clienteDTO.getTelefono());
            c.setContrasena(clienteDTO.getContrasena());
            c.setEstado(Boolean.TRUE);
            ClienteEntity save = clienteRepository.save(c);
            publisher.send(save);
            return save;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) throws BussinesRuleException {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        if (!cliente.isEmpty()) {
            clienteRepository.delete(cliente.get());
        } else {
            BussinesRuleException exception = new BussinesRuleException(INFO_URL);
            throw exception;
        }
    }

    @Override
    public void put(ClienteDTO clienteDTO, BindingResult result, Long id) throws BussinesRuleException, BussinesRuleValidationException {
        Optional<ClienteEntity> find = clienteRepository.findById(id);

        if (!find.isEmpty()) {
            if (result.hasErrors()) {
                BussinesRuleValidationException exception = new BussinesRuleValidationException(INFO_URL, result);
                throw exception;
            } else {
                find.get().setNombre(clienteDTO.getNombre());
                find.get().setGenero(clienteDTO.getGenero());
                find.get().setEdad(clienteDTO.getEdad());
                find.get().setIdentificacion(clienteDTO.getIdentificacion());
                find.get().setDireccion(clienteDTO.getDireccion());
                find.get().setTelefono(clienteDTO.getTelefono());
                find.get().setContrasena(clienteDTO.getContrasena());
                find.get().setEstado(clienteDTO.getEstado());
                ClienteEntity save = clienteRepository.save(find.get());
                clienteRepository.save(save);
                //publisher.send(save);
            }
        } else {
            BussinesRuleException exception = new BussinesRuleException(INFO_URL);
            throw exception;
        }

    }
}
