package dc.hope.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
    @Positive
    private int quantidade;
    
}
