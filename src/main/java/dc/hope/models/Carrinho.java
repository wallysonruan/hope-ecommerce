package dc.hope.models;

import java.util.List;

import dc.hope.request.PedidoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Carrinho {
  private List<Produtos> carrinhoProdutos;
  private  PedidoRequest carrinhoPedidoRequest;

  public void adcionarProduto(Produtos novoProdutos){
      carrinhoProdutos.add(novoProdutos);
      
  }

  public void removerProduto(Produtos novoProdutos){
    carrinhoProdutos.remove(novoProdutos);
  }
}
