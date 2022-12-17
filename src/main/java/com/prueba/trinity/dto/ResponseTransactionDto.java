package com.prueba.trinity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba.trinity.models.Client;
import lombok.*;

import javax.persistence.*;

/**
 * Clase encargada de mostrar la respuesta de datos de la transferencia
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTransactionDto {

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("estado")
    private String status;

    @JsonProperty("valor")
    private String value;

    @JsonProperty("numeroDocumento")
    private String documentNumber;

    @JsonProperty("Nombre")
    private String name;

}
