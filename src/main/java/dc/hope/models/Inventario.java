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
    private ChaveProdutoPedido id = new ChaveProdutoPedido();

    @ManyToOne
    @MapsId("produtoId")
    Produtos produto;

    @ManyToOne
    @MapsId("pedidoId")
    Pedidos pedido;
    
    private int quantidade;
}
