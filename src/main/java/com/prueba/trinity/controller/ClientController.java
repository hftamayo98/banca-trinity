package com.prueba.trinity.controller;

import com.prueba.trinity.dto.ClientDto;
import com.prueba.trinity.models.Client;
import com.prueba.trinity.response.Response;
import com.prueba.trinity.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/list")
    public Response<List<Client>> ListBrands() {
        return Response.<List<Client>>builder()
                .failure(false)
                .code(HttpStatus.OK.value())
                .body(clientService.getAllClients())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @PostMapping("/create")
    public Response<Object> createClient(@RequestBody ClientDto requestClient) {
        return Response.<Object>builder()
                .failure(false)
                .code(HttpStatus.OK.value())
                .body(clientService.createClient(requestClient))
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @PutMapping("/update")
    public Response<ClientDto> updateDataCliente(@RequestBody ClientDto requestClient) {
        return Response.<ClientDto>builder()
                .failure(false)
                .code(HttpStatus.OK.value())
                .body(clientService.updateDataClient(requestClient))
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @PostMapping("/find-client")
    public Response<ClientDto> findClient(@RequestBody ClientDto requestClient) {
        return Response.<ClientDto>builder()
                .failure(false)
                .code(HttpStatus.OK.value())
                .body(clientService.getClient(requestClient.getDocumentNumber()))
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

}
