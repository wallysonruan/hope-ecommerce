import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

@Embeddable
@AllArgsConstructor
@Builder

class ChaveProdutoPedido implements Serializable {
    @Column(name = "produto_id")
    private Long produtoId;

    @Column(name="pedido_id")
    private Long pedidoId;
}