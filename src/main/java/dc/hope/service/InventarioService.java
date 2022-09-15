package dc.hope.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dc.hope.exceptions.DefaultException;
import dc.hope.models.ChaveProdutoPedido;
import dc.hope.models.Inventario;
import dc.hope.models.Pedido;
import dc.hope.models.Produto;
import dc.hope.repository.InventarioRepository;
import dc.hope.request.InventarioRequest;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class InventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    private final PedidoService pedidoService;
    private final ProdutoService produtoService;

    public Inventario findById(ChaveProdutoPedido chave){
        return inventarioRepository.findById(chave).orElseThrow(new DefaultException(HttpStatus.BAD_REQUEST, "Pedido ou produto não encontrado"));
        }

    public Pedido addProduto(InventarioRequest inventarioRequest){

        int quantidade = inventarioRequest.getQuantidade();
        Produto produto = produtoService.findById(inventarioRequest.getProdutoId());
        Pedido pedido = pedidoService.checarPedidoFechadoERetornar(inventarioRequest.getPedidoId());
        ChaveProdutoPedido chave = new  ChaveProdutoPedido(inventarioRequest.getPedidoId(), inventarioRequest.getProdutoId());

        if(quantidade < produto.getEstoque()){throw new DefaultException(HttpStatus.BAD_REQUEST, "Sem estoque suficiente");}
        else{
            if(!inventarioRepository.findById(chave).isEmpty()){
                Inventario inventario = findById(chave);
                inventario.setQuantidade(inventario.getQuantidade() + quantidade);
                inventarioRepository.save(inventario);
                produtoService.removerEstoque(produto, quantidade);
                return pedidoService.adicionarValorProduto(pedido, produto, quantidade);
                          }
            else{
            Inventario inventario = Inventario.builder()
            .quantidade(quantidade)
            .produto(produto)
            .pedido(pedidoService.findById(inventarioRequest.getPedidoId()))
            .build();
            inventarioRepository.save(inventario);
            produtoService.removerEstoque(produto, quantidade);
            return pedidoService.adicionarValorProduto(pedido, produto, quantidade);
        }
    }
 
      }

    public Pedido removeProduto(InventarioRequest inventarioRequest){

        int quantidade = inventarioRequest.getQuantidade();
        Produto produto = produtoService.findById(inventarioRequest.getProdutoId());
        Pedido pedido = pedidoService.checarPedidoFechadoERetornar(inventarioRequest.getPedidoId());  
        ChaveProdutoPedido chave = new  ChaveProdutoPedido(inventarioRequest.getPedidoId(), inventarioRequest.getProdutoId());
        Inventario inventario = findById(chave);
        int quantidadeAnterior = inventario.getQuantidade();
        
        if(quantidadeAnterior <= quantidade){
            produtoService.reporEstoque(produto, quantidade);
            inventarioRepository.deleteById(inventario.getId());
            return pedidoService.removerValorProduto(pedido, produto, quantidade); }
        else{
            inventario.setQuantidade(quantidadeAnterior - quantidade);
            produtoService.reporEstoque(produto, quantidade);
            return pedidoService.removerValorProduto(pedido, produto, quantidade);
        }
        
      }

    }
    

