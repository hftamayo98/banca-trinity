package com.prueba.trinity.repository;

import com.prueba.trinity.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase encargada de realizar los query en la base de datos
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByDocumentNumber (Integer documentNumber);

}
