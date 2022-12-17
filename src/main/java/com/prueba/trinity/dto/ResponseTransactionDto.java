package com.prueba.trinity.dto;

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

    private String uuid;

    private String status;

    private String value;

    private Client client;

}
