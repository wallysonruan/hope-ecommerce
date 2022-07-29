package dc.hope.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dc.hope.exceptions.DefaultException;
import dc.hope.models.ChaveProdutoPedido;
import dc.hope.models.Inventario;
import dc.hope.models.Pedidos;
import dc.hope.models.Produtos;
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

    public Pedidos addProduto(InventarioRequest inventarioRequest){

        int quantidade = inventarioRequest.getQuantidade();
        Produtos produto = produtoService.findById(inventarioRequest.getProdutoId());
        Pedidos pedido = pedidoService.findById(inventarioRequest.getPedidoId());
        if(pedido.isPedido_fechado()){throw new DefaultException(HttpStatus.BAD_REQUEST, "Este pedido já está fechado e não pode mais ser alterado");}
        int estoque = produto.getEstoque();
        double valortotal = pedido.getValor_total();
        double valordoacao = pedido.getValor_doacao();
        ChaveProdutoPedido chave = new  ChaveProdutoPedido(inventarioRequest.getPedidoId(), inventarioRequest.getProdutoId());

        if( estoque < quantidade){throw new DefaultException(HttpStatus.BAD_REQUEST, "Sem estoque suficiente");}
        else{
            if(!inventarioRepository.findById(chave).isEmpty()){
                Inventario inventario = findById(chave);
                inventario.setQuantidade(inventario.getQuantidade() + quantidade);
                inventarioRepository.save(inventario);
                produto.setEstoque(estoque - quantidade);
                produtoService.salvar(produto);
                pedido.setValor_total(valortotal + produto.getPreco()*quantidade);
                pedido.setValor_doacao(valordoacao + produto.getPreco()*produto.getDoacao()*quantidade);
                return pedidoService.salvar(pedido);
                          }
            else{
            Inventario inventario = Inventario.builder()
            .quantidade(quantidade)
            .produto(produto)
            .pedido(pedido)
            .build();
            produto.setEstoque(estoque - quantidade);
            inventarioRepository.save(inventario);
            produtoService.salvar(produto);
            pedido.setValor_total(valortotal + produto.getPreco()*quantidade);
            pedido.setValor_doacao(valordoacao + produto.getPreco()*produto.getDoacao()*quantidade);
            return pedidoService.salvar(pedido);
        }
    }
 
      }

    public Pedidos removeProduto(InventarioRequest inventarioRequest){

        int quantidade = inventarioRequest.getQuantidade();
        Produtos produto = produtoService.findById(inventarioRequest.getProdutoId());
        Pedidos pedido = pedidoService.findById(inventarioRequest.getPedidoId());
        if(pedido.isPedido_fechado()){throw new DefaultException(HttpStatus.BAD_REQUEST, "Este pedido já está fechado e não pode mais ser alterado");}
        int estoque = produto.getEstoque();
        double valortotal = pedido.getValor_total();
        double valordoacao = pedido.getValor_doacao();
        
        ChaveProdutoPedido chave = new  ChaveProdutoPedido(inventarioRequest.getPedidoId(), inventarioRequest.getProdutoId());

        Inventario inventario = findById(chave);
        int quantidadeAnterior = inventario.getQuantidade();
        if(quantidadeAnterior <= quantidade){
            produto.setEstoque(estoque + quantidadeAnterior);
            produtoService.salvar(produto);
            pedidoService.salvar(pedido);
            inventarioRepository.deleteById(inventario.getId());;
            pedido.setValor_total(valortotal - produto.getPreco()*quantidadeAnterior);
            pedido.setValor_doacao(valordoacao - produto.getPreco()*produto.getDoacao()*quantidadeAnterior);
            return pedidoService.salvar(pedido);        }
        else{
            inventario.setQuantidade(quantidadeAnterior - quantidade);
            produto.setEstoque(estoque + quantidade);
            produtoService.salvar(produto);
            pedido.setValor_total(valortotal - produto.getPreco()*quantidade);
            pedido.setValor_doacao(valordoacao - produto.getPreco()*produto.getDoacao()*quantidade);
            return pedidoService.salvar(pedido);   
        }
        
      }

    }
    

