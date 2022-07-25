package models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
@Builder

public class Pedidos {
  
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;


    @ManyToOne
    @JoinColumn(name = "ong_id")
    private Ongs ong;

    @Column
    private Date data;

    @Column
    private String forma_pagamento;

    @Column
    private double valor_total;

    @Column
    private double valor_doacao;

    @OneToMany(mappedBy = "pedidos")
    Set<Inventario> quantidade;
}
