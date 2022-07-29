package dc.hope.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class InventarioRequest {

    @NotNull(message = "É preciso informar Id do Pedido, Id do produto e quantidade desejada")
    private Long pedidoId;


    @NotNull(message = "É preciso informar Id do Pedido, Id do produto e quantidade desejada")
    private Long produtoId;

    @NotNull(message = "É preciso informar Id do Pedido, Id do produto e quantidade desejada")
    private int quantidade;
    
}
