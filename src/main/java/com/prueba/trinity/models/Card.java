package com.prueba.trinity.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

/**
 * Clase encargada de manejar la entidad Cliente en la base de datos
 */
@Entity(name = "cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {

    /**
     * Llave primaria para identificar la cuenta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number_card", length = 35, nullable = false)
    private String numberCard;

    @Column(name = "exp_date")
    private String expDate;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "balance")
    private String balance;

    @ManyToOne
    @JoinColumn(name = "client_document_number")
    private Client client;

}
