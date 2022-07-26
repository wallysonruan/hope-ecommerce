package dc.hope.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pedidos")
@Builder
@Data

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

    @ManyToMany
    @JoinTable(name="inventario_pedidos_produtos",
    joinColumns = {@JoinColumn(name="pedido_id")},
    inverseJoinColumns = {@JoinColumn(name="produto_id")})
    private Set<Produtos> produtos = new HashSet<Produtos>();
}
