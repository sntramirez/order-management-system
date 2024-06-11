package com.altioracorp.ordermanagement.infraestructure.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "orden_id_seq" , allocationSize = 1)
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    private String codigo;
    private Date fecha;

}
