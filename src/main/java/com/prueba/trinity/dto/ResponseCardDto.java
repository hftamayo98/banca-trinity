package com.prueba.trinity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba.trinity.models.Client;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCardDto {

    @JsonProperty("numeroTarjeta")
    private String numberCard;

    @JsonProperty("fechaExpiracion")
    private String expDate;

    @JsonProperty("cvv")
    private String cvv;

    @JsonProperty("saldo")
    private String balance;

    @JsonProperty("cliente")
    private Client client;

}
