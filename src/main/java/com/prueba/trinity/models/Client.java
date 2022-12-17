package com.prueba.trinity.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

/**
 * Clase encargada de manejar la entidad Cliente en la base de datos
 */
@Entity(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    /**
     * Llave primaria para identificar el cliente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * tipo de documento del cliente
     */
    @Column(name = "document_type", length = 35, nullable = false)
    @JsonProperty("tipoDocumento")
    private String documentType;

    /**
     * numero de documento del cliente
     */
    @Column(name = "document_number", length = 35, nullable = false)
    @JsonProperty("numeroDocumento")
    private Integer documentNumber;

    @Column(name = "status")
    @JsonProperty(namespace = "estado")
    private Boolean status;

    /**
     * primer nombre del cliente
     */
    @Column(name = "first_name", length = 15, nullable = false)
    @JsonProperty("primerNombre")
    private String firstName;

    /**
     * segundo nombre del cliente
     */
    @Column(name = "second_name", length = 15, nullable = false)
    @JsonProperty("segundoNombre")
    private String secondName;

    /**
     * primer apellido del cliente
     */
    @Column(name = "first_surname", length = 20, nullable = false)
    @JsonProperty("primerApellido")
    private String firstSurname;

    /**
     * segundo apellido del cliente
     */
    @Column(name = "second_surname", length = 20, nullable = false)
    @JsonProperty("segundoApellido")
    private String secondSurname;


}
