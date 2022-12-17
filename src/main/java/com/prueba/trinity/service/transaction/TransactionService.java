package com.prueba.trinity.service.transaction;

import com.prueba.trinity.dto.RequestTransactionDto;
import com.prueba.trinity.dto.ResponseTransactionDto;

public interface TransactionService {

    ResponseTransactionDto generatedTransaction(RequestTransactionDto requestTransaction);

}
