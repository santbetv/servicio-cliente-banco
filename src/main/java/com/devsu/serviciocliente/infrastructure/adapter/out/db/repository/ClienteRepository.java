package com.devsu.serviciocliente.infrastructure.adapter.out.db.repository;


import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * @author Santiago Betancur
 */
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    // Busca un cliente por su número de identificación
    Optional<ClienteEntity> findByIdentificacion(String identificacion);

    // Verifica si existe un cliente con un número de teléfono específico
    boolean existsByTelefono(String telefono);

    // Obtiene una lista de clientes según su estado (activo/inactivo)
    List<ClienteEntity> findAllByEstado(Boolean estado);

}
