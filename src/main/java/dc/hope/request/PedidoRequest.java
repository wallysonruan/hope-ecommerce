package dc.hope.request;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PedidoRequest {

    private Long clienteId;
    private Long ongId;
    private String formaPagamento;
  
    
}
