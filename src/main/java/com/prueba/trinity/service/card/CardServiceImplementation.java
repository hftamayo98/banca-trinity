package com.prueba.trinity.service.card;

import com.prueba.trinity.dto.RequestCardDto;
import com.prueba.trinity.dto.ResponseCardDto;
import com.prueba.trinity.models.Card;
import com.prueba.trinity.models.Client;
import com.prueba.trinity.repository.CardsRepository;
import com.prueba.trinity.repository.ClientRepository;
import com.prueba.trinity.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImplementation implements CardService{

    @Autowired
    CardsRepository cardsRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ResponseCardDto createCard(RequestCardDto requestCard) {
        Client client = clientRepository.findByDocumentNumber(requestCard.getDocumentNumber());
        if (!client.equals(null)){
            cardsRepository.save(
                    Card.builder()
                            .numberCard(requestCard.getNumberCard())
                            .expDate(requestCard.getExpDate())
                            .cvv(requestCard.getCvv())
                            .balance(requestCard.getBalance())
                            .client(client)
                            .build()
            );
        }else {
            throw new RuntimeException(Constants.EXCEPTION_CREATE_CARD);
        }

        return ResponseCardDto.builder()
                .numberCard(requestCard.getNumberCard())
                .expDate(requestCard.getExpDate())
                .cvv(requestCard.getCvv())
                .balance(requestCard.getBalance())
                .client(client)
                .build();
    }

    @Override
    public List<Card> listCards() {
        return cardsRepository.findAll();
    }
}
