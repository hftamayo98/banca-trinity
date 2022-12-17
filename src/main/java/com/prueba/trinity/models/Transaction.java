package com.prueba.trinity.models;

import lombok.*;

import javax.persistence.*;

/**
 * Clase encargada de manejar la entidad transacciones en la base de datos
 */
@Entity(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    /**
     * Llave primaria para identificar el id de transaccion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "transaction_id")
    private String uuid;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "cards_id")
    private Card card;

}
