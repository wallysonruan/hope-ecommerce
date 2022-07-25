package dc.hope.models;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table(name="inventario_pedidos_produtos")
@Builder


public class Inventario {

    @EmbeddedId
    ChaveProdutoPedido id;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "produto_id")
    private Produtos produto;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;
    
    int quantidade;
}
