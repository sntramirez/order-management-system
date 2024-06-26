package com.altioracorp.ordermanagement.infraestructure.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "ordenes_id_seq" , allocationSize = 1)
@Table(name = "tb_ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    private String codigo;
    @Column(name = "cliente_id")
    private Long clienteId;
    private Date fecha;

}
