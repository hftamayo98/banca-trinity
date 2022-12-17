package com.prueba.trinity.service.client;

import com.prueba.trinity.dto.ClientDto;
import com.prueba.trinity.models.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Servicio con los metodos correspondientes para las acciones de un usuario
 */
public interface ClientService {

    List<Client> getAllClients();
    Object createClient(ClientDto requestClient);
    ClientDto updateDataClient(ClientDto requestClient);

    ClientDto getClient(Integer documentNumber);


}
