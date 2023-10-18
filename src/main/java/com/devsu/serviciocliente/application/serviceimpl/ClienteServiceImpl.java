package com.devsu.serviciocliente.application.serviceimpl;


import com.devsu.serviciocliente.infrastructure.adapter.out.notification.Publisher;
import com.devsu.serviciocliente.domain.port.out.db.IClienteService;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.repository.ClienteRepository;
import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.Cliente;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

//    @Override
//    @Transactional(readOnly = true) //
//    public Cliente findById(Long id) {
//        Optional<Cliente> cliente = clienteRepository.findById(id);
//        
//        if (!cliente.isEmpty()) {
//            List<Cuenta> cuentas = handleMessage.getCuentas();
//            
//            for (Cuenta cuenta : cuentas) {
//                if (cuenta.getCliente().getIdCliente().equals(cliente.get().getIdCliente())) {
//
//                    cliente.get().setCuentas(cuentas);
//                    //System.out.println("Cuenta válida: " + cuenta);
//                }
//            }
//            return clienteRepository.findById(id).get();
//        } else {
//             throw new UnsupportedOperationException("Not supported yet.");
//        }
//    }
    
    @Override
    @Transactional(readOnly = true) //
    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (!cliente.isEmpty()) {
            return clienteRepository.findById(id).get();
        } else {
             throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    

    @Override
    @Transactional(readOnly = true) //
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional //
    public Cliente save(Cliente clienteDTO){
            Cliente c = new Cliente();
            c.setNombre(clienteDTO.getNombre());
            c.setGenero(clienteDTO.getGenero());
            c.setEdad(clienteDTO.getEdad());
            c.setIdentificacion(clienteDTO.getIdentificacion());
            c.setDireccion(clienteDTO.getDireccion());
            c.setTelefono(clienteDTO.getTelefono());
            c.setContrasena(clienteDTO.getContrasena());
            c.setEstado(Boolean.TRUE);
            Cliente save = clienteRepository.save(c);
            publisher.send(save);
            return save;
    }
}
