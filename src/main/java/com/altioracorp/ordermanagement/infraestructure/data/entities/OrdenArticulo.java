package com.altioracorp.ordermanagement.infraestructure.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "orden_articulo_id_seq", allocationSize = 1)
@Table(name = "tb_orden_articulo")
public class OrdenArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "orden_id")
    private Long ordenId;

    @Column(name = "articulo_id")
    private Long articuloId;

    private Long cantidad;
}
