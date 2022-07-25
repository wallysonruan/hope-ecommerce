package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Embeddable
@AllArgsConstructor
@Builder

class ChaveProdutoPedido implements Serializable {
    @Column(name = "produto_id")
    private Long produtoId;

    @Column(name="pedido_id")
    private Long pedidoId;
}