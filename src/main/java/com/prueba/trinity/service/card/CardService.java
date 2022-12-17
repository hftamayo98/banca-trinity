package com.prueba.trinity.service.card;

import com.prueba.trinity.dto.RequestCardDto;
import com.prueba.trinity.dto.ResponseCardDto;
import com.prueba.trinity.models.Card;

import java.util.List;

public interface CardService {

    ResponseCardDto createCard(RequestCardDto requestCard);

    List<Card> listCards();

}
