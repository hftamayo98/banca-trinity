package com.prueba.trinity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestCardDto {

    @JsonProperty("numeroTarjeta")
    private String numberCard;

    @JsonProperty("fechaExpiracion")
    private String expDate;

    @JsonProperty("cvv")
    private String cvv;

    @JsonProperty("saldo")
    private String balance;

    @JsonProperty("numeroDocumento")
    private Integer documentNumber;

}
