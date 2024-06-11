package com.altioracorp.ordermanagement.infraestructure.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "cliente_id_seq" , allocationSize = 1)
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    private String nombre;
    private String apellido;
}
