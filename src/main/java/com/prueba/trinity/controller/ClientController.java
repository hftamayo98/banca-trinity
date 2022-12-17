package com.prueba.trinity.controller;

import com.prueba.trinity.dto.ClientDto;
import com.prueba.trinity.models.Client;
import com.prueba.trinity.response.Response;
import com.prueba.trinity.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createClient(@RequestBody ClientDto requestClient) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(clientService.createClient(requestClient));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDataCliente(@RequestBody ClientDto requestClient) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(clientService.updateDataClient(requestClient));
    }

}
