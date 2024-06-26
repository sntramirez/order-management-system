package com.altioracorp.ordermanagement.infraestructure.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "articulos_id_seq" , allocationSize = 1)
@Table(name = "tb_articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    private String codigo;
    private String nombre;
    private Integer stock;
    private double precioUnitario;
}
