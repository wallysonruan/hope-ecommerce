package dc.hope.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProdutoRequest {


    private String nome;
    private int estoque;
    private double preco;
    private double doacao;
   
}
