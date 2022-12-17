package com.prueba.trinity.service;

import com.prueba.trinity.dto.ClientDto;
import com.prueba.trinity.models.Client;
import com.prueba.trinity.repository.ClientRepository;
import com.prueba.trinity.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientServiceImplementation implements ClientService {

    @Autowired
    ClientRepository clientRepository;


    /**
     * Metodo encargado de traer todos los usuarios registrados
     * @return
     */
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Metodo encargado de crear un nuevo usuario
     * @param requestClient
     * @return
     */
    @Override
    public Object createClient(ClientDto requestClient) {
        return clientRepository.save(
                Client.builder()
                        .documentType(requestClient.getDocumentType())
                        .documentNumber(requestClient.getDocumentNumber())
                        .firstName(requestClient.getFirstName())
                        .secondName(requestClient.getSecondName())
                        .firstSurname(requestClient.getFirstSurname())
                        .secondSurname(requestClient.getSecondSurname()).build()
        );
    }

    /**
     * Metodo encargado de actualizar la data de una persona
     * @param requestClient
     * @return
     */
    @Override
    public ClientDto updateDataClient(ClientDto requestClient) {
        Client client = clientRepository.findByDocumentNumber(requestClient.getDocumentNumber());
        if (client.equals(null)) throw new RuntimeException(Constants.EXCEPTION_NOT_DATA_FOUND);
        clientRepository.save(updateData(client, requestClient));
        return requestClient;
    }

    /**
     * Metodo encargado de actualiar la data de una persona
     * @param client data del cliente actual
     * @param newData datos nuevos
     * @return
     */
    private Client updateData(Client client, ClientDto newData){
        client.setFirstName(newData.getFirstName());
        client.setSecondName(newData.getSecondName());
        client.setFirstSurname(newData.getFirstSurname());
        client.setSecondSurname(newData.getSecondSurname());
        return client;
    };
}
