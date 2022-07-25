import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Entity
@Table(name="inventario_pedidos_produtos")
@Builder


public class inventario {

    @ManyToMany
    @MapsId(name="produtoId")
    @JoinColumn(name = "produto_id")
    private Produtos produto;

    @ManyToMany
    @MapsID(name="pedidoId")
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;
    
    @Column
    private int quantidade;
}
