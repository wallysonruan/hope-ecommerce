package dc.hope.models;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="inventario_pedidos_produtos")
@Builder
@AllArgsConstructor
@Data


public class Inventario {

    @EmbeddedId
    private final ChaveProdutoPedido id = new ChaveProdutoPedido();

    @ManyToOne
    @MapsId("produtoId")
    private Produtos produto;

    @ManyToOne
    @MapsId("pedidoId")
    private Pedidos pedido;
    
    private int quantidade;


    public Inventario(){};


}


