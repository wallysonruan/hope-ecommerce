package dc.hope.request;

import dc.hope.models.Inventario;
import dc.hope.models.Pedidos;
import dc.hope.models.Produtos;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class InventarioRequest {

    private Pedidos pedido_id;
    private Produtos produto_id;
    private int quantidade;
    
    public Inventario converterClasse(){
        return Inventario.builder()
        .pedido(this.pedido_id)
        .produto(this.produto_id)
        .quantidade(this.quantidade)
        .build();


    }
}
