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
    private int estoque;

    
    @Positive
    private double preco;

    @Positive
    private double doacao;
   
}
