package dc.hope.request;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProdutoUpdateRequest {

    
    private String nome;
    
    @PositiveOrZero
    private Integer estoque;

    
    @Positive
    private Double preco;

    @Positive
    private Double doacao;
   
}
