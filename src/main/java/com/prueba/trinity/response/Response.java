package com.prueba.trinity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Response<T> {

    private static final long serialVersionUID = 167L;

    /**
     * Indica si se presenta algun fallo en el servicio
     */
    @ApiModelProperty(
            value = "Indica si se presenta algun fallo en el servicio",
            name = "failure")
    private boolean failure;

    /**
     * Indica el codigo de respuesta de la peticion
     */
    @ApiModelProperty(
            value = "Indica el codigo de respuesta de la peticion",
            name = "code")
    private int code;

    /**
     * Indica un mensaje en caso de falla
     */
    @ApiModelProperty(
            value = "Indica un mensaje en caso de falla",
            name = "message")
    private String message;

    /**
     * Clase generica que almacena la respuesta del servicio
     */
    @ApiModelProperty(
            value = "Clase generica para respuesta del servicio",
            name = "body",
            dataType = "T")
    private T body;

    /**
     * Indica el tiempo exacto en milisegundos del momento que se ejecuta la peticion
     */
    @ApiModelProperty(
            value = "Indica el tiempo en el que se ejecuta la peticion",
            name = "timestamp",
            dataType = "String",
            example = "14420054")
    private String timestamp;

}
