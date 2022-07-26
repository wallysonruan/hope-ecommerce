package dc.hope.service;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dc.hope.models.Carrinho;
import dc.hope.models.Clientes;
import dc.hope.models.Ongs;
import dc.hope.models.Produtos;
import dc.hope.request.PedidoRequest;

public class CarrinhoService {

  private List<Produtos> carrinhoProdutos;
  private  PedidoRequest carrinhoPedidoRequest;

  @Autowired
  Carrinho carrinho;

  public void abrirCarrinho(Clientes cliente){
    carrinhoPedidoRequest.setCliente_id(cliente);
    carrinhoPedidoRequest.setData(LocalDate.now());
    
  }

  public void adcionarProduto(Produtos novoProdutos){
    carrinhoProdutos.add(novoProdutos);
    
}

  public void removerProduto(Produtos novoProdutos){
    carrinhoProdutos.remove(novoProdutos);
}
  public void adcionarOng(Ongs ong){
    carrinhoPedidoRequest.setOng_id(ong);
  }
  
}
