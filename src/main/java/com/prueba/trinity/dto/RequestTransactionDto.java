package com.prueba.trinity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba.trinity.models.Client;
import lombok.*;

import javax.persistence.*;

/**
 * Clase encargada de la transferencia de datos de la transaccion
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestTransactionDto {

    @JsonProperty("valor")
    private String value;

    @JsonProperty("numeroTarjeta")
    private String cardNumber;


}
