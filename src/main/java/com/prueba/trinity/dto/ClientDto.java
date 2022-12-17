package com.prueba.trinity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Clase encargada de la transferencia de datos
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {

    @JsonProperty("tipoDocumento")
    private String documentType;

    @JsonProperty("numeroDocumento")
    private Integer documentNumber;

    @JsonProperty("primerNombre")
    private String firstName;

    @JsonProperty("segundoNombre")
    private String secondName;

    @JsonProperty("primerApellido")
    private String firstSurname;

    @JsonProperty("segundoApellido")
    private String secondSurname;


}
