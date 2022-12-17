package com.prueba.trinity.controller;

import com.prueba.trinity.dto.ClientDto;
import com.prueba.trinity.dto.RequestTransactionDto;
import com.prueba.trinity.response.Response;
import com.prueba.trinity.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/generated")
    public Response<Object> generatedTransaction(@RequestBody RequestTransactionDto requestTransaction) {
        return Response.<Object>builder()
                .failure(false)
                .code(HttpStatus.OK.value())
                .body(transactionService.generatedTransaction(requestTransaction))
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

}
