package dc.hope.request;

import dc.hope.models.Produtos;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProdutoRequest {


    private String nome;
    private int estoque;
    private double preco;
    private double doacao;

    public Produtos converterClasse(){
        return Produtos.builder()
        .nome(this.nome)
        .estoque(this.estoque)
        .preco(this.preco)
        .doacao(this.doacao)
        .build();
    }
    
}
