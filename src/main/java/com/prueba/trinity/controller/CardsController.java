package com.prueba.trinity.controller;

import com.prueba.trinity.dto.RequestCardDto;
import com.prueba.trinity.models.Card;
import com.prueba.trinity.response.Response;
import com.prueba.trinity.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardService cardService;

    @PostMapping("/create")
    public Response<Object> createCard(@RequestBody RequestCardDto requestCard) {
        return Response.<Object>builder()
                .failure(false)
                .code(HttpStatus.OK.value())
                .body(cardService.createCard(requestCard))
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }

    @GetMapping("/list")
    public Response<List<Card>> ListBrands() {
        return Response.<List<Card>>builder()
                .failure(false)
                .code(HttpStatus.OK.value())
                .body(cardService.listCards())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
    }


}
