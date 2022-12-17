package com.prueba.trinity.service.transaction;

import com.prueba.trinity.dto.ClientDto;
import com.prueba.trinity.dto.RequestTransactionDto;
import com.prueba.trinity.dto.ResponseTransactionDto;
import com.prueba.trinity.models.Card;
import com.prueba.trinity.models.Client;
import com.prueba.trinity.models.Transaction;
import com.prueba.trinity.repository.CardsRepository;
import com.prueba.trinity.repository.ClientRepository;
import com.prueba.trinity.repository.TransactionRepository;
import com.prueba.trinity.service.client.ClientService;
import com.prueba.trinity.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImplementation implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CardsRepository cardsRepository;


    @Override
    public ResponseTransactionDto generatedTransaction(RequestTransactionDto requestTransactionDto) {
        Card card = cardsRepository.findCardByNumberCard(requestTransactionDto.getCardNumber());

        if (card.equals(null) || Integer.valueOf(card.getBalance()) < Integer.valueOf(requestTransactionDto.getValue()))
            throw new RuntimeException(Constants.EXCEPTION_TRANSACTION_ERROR);
        Transaction transaction = transactionRepository.save(Transaction.builder()
                .uuid(UUID.randomUUID().toString())
                .status(true)
                .value(requestTransactionDto.getValue())
                .card(card)
                .build());

        card.setBalance(
                String.valueOf(Integer.valueOf(card.getBalance()) - Integer.valueOf(requestTransactionDto.getValue()))
        );
        cardsRepository.save(card);

        return ResponseTransactionDto.builder()
                .uuid(transaction.getUuid())
                .status(transaction.getStatus().equals(true) ? "Abierta" : "Fallo")
                .value(transaction.getValue())
                .name(
                        card.getClient().getFirstName() + " " +
                                card.getClient().getFirstSurname()
                )
                .documentNumber(String.valueOf(card.getClient().getDocumentNumber()))
                .build();
    }
}
