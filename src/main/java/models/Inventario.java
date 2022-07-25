package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table(name="inventario_pedidos_produtos")
@Builder


public class Inventario {

    @ManyToMany
    @MapsId("produtoId")
    @JoinColumn(name = "produto_id")
    private Produtos produto;

    @ManyToMany
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;
    
    @Column
    private int quantidade;
}
