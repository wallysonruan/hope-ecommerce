package dc.hope.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class InventarioRequest {

    private Long pedidoId;
    private Long produtoId;
    private int quantidade;
    
}
