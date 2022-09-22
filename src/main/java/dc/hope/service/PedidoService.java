package dc.hope.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dc.hope.exceptions.DefaultException;
import dc.hope.models.ChaveProdutoPedido;
import dc.hope.models.Pedido;
import dc.hope.models.Produto;
import dc.hope.repository.InventarioRepository;
import dc.hope.repository.PedidosRepository;
import dc.hope.request.PedidoRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PedidoService {

    private final PedidosRepository pedidosRepository;

    private final InventarioRepository inventarioRepository;

    private final ClienteService clienteService;
    private final OngService ongService;

    public Pedido salvar (Pedido pedidos){
        return pedidosRepository.save(pedidos);

    }

    public Pedido findById(Long id){
        return pedidosRepository.findById(id).orElseThrow(new DefaultException(HttpStatus.BAD_REQUEST, "Pedido não encontrado"));
    }

    public List<Pedido> findAllById(){
        return pedidosRepository.findAll();
    }

    public void  deletar(Long id){
        var objeto = findById(id);
        pedidosRepository.delete(objeto);
    }
 
    public Pedido abrirPedido(PedidoRequest pedidoRequest){
        Pedido pedidos = Pedido.builder()
        .cliente(clienteService.findById(pedidoRequest.getClienteId()))
        .ong(ongService.findById(pedidoRequest.getOngId()))
        .data(LocalDate.now())
        .forma_pagamento(pedidoRequest.getFormaPagamento())
        .build();
        return pedidosRepository.save(pedidos);
    }

    public String fecharPedido(Long idPedido) {
        Pedido pedido = findById(idPedido);
        if(pedido.isPedido_fechado()){throw new DefaultException(HttpStatus.BAD_REQUEST, "Este pedido já está fechado e não pode mais ser alterado");};
        if(pedido.getProdutos().isEmpty()){throw new DefaultException(HttpStatus.BAD_REQUEST, "Este pedido não contém produtos, não pode ser fechado");}
        pedido.setPedido_fechado(true);
        pedidosRepository.save(pedido);
        List<String> mensagem = new ArrayList<>();
        mensagem.add("Ficamos muito contentes com sua compra, "+pedido.getCliente().getNome());
        mensagem.add("Seu Id de pedido é: "+pedido.getId());
        mensagem.add("Estes são os itens em seu pedido");
        for (Produto produto : pedido.getProdutos()) {
            ChaveProdutoPedido chave = new ChaveProdutoPedido(pedido.getId(), produto.getId());
            mensagem.add("Item: "+produto.getNome());
            mensagem.add("Preço unitário: "+produto.getPreco());
            mensagem.add("Valor unitário convertido em doação: "+produto.getDoacao() * produto.getPreco());
            mensagem.add("Quantidade: "+inventarioRepository.findById(chave).get().getQuantidade());
        }
        mensagem.add("O valor total do seu pedido é: "+pedido.getValor_total());
        mensagem.add("Com essa compra, você gerou "+pedido.getValor_doacao()+" para a Ong "+pedido.getOng().getNome());
        mensagem.add("Você escolheu pagar utilizando "+pedido.getForma_pagamento());
        return mensagem.toString();
    }

    public Pedido adicionarValorProduto(Pedido pedido, Produto produto, int quantidade){
        double valortotal = pedido.getValor_total();
        double valordoacao = pedido.getValor_doacao();
        pedido.setValor_total(valortotal + produto.getPreco()*quantidade);
        pedido.setValor_doacao(valordoacao + produto.getPreco()*produto.getDoacao()*quantidade);
        return pedidosRepository.save(pedido);
    
    
    }
    
    public Pedido removerValorProduto(Pedido pedido, Produto produto, int quantidade){
        double valortotal = pedido.getValor_total();
        double valordoacao = pedido.getValor_doacao();
        pedido.setValor_total(valortotal - produto.getPreco()*quantidade);
        pedido.setValor_doacao(valordoacao - produto.getPreco()*produto.getDoacao()*quantidade);
        return pedidosRepository.save(pedido);
        
        
    }

    public Pedido checarPedidoFechadoERetornar(Long idPedido){
        if(findById(idPedido).isPedido_fechado()){throw new DefaultException(HttpStatus.BAD_REQUEST, "Este pedido já está fechado e não pode mais ser alterado");
        }
        else {return findById(idPedido);
        }
    }

}


