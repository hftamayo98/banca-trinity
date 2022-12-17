package com.prueba.trinity.repository;

import com.prueba.trinity.models.Card;
import com.prueba.trinity.models.Client;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends JpaRepository<Card, Integer> {

    Card findCardByNumberCard(String NumberCard);

}
