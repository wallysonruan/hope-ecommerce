package dc.hope.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name="pedidos")
@Builder
@AllArgsConstructor
@Data

public class Pedido {
  
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(name = "ong_id")
    private Ong ong;

    @Column
    private LocalDate data;

    @Column
    private String forma_pagamento;

    @Column
    private double valor_total;

    @Column
    private double valor_doacao;

    @Column
    @Builder.Default
    private boolean pedido_fechado = false;

    @Builder.Default
    @ManyToMany
    @JoinTable(name="inventario_pedidos_produtos",
    joinColumns = {@JoinColumn(name="pedido_id")},
    inverseJoinColumns = {@JoinColumn(name="produto_id")})
    private List<Produto> produtos = new ArrayList<>();

    public Pedido(){}
   
}
