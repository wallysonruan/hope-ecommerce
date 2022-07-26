package dc.hope.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable

public class ChaveProdutoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
 
    private Long pedidoId;
    private Long produtoId;
 
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((produtoId == null) ? 0 : produtoId.hashCode());
        result = prime * result
                + ((pedidoId == null) ? 0 : pedidoId.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChaveProdutoPedido other = (ChaveProdutoPedido) obj;
        return Objects.equals(getPedidoId(), other.getPedidoId()) && Objects.equals(getProdutoId(), other.getProdutoId());
    }
}
