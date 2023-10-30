package com.devsu.serviciocliente.infrastructure.adapter.out.db.repository;


import com.devsu.serviciocliente.infrastructure.adapter.out.db.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
*
* @author Santiago Betancur
*/
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
