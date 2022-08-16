package dc.hope.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dc.hope.exceptions.DefaultException;
import dc.hope.models.ChaveProdutoPedido;
import dc.hope.models.Pedidos;
import dc.hope.models.Produtos;
import dc.hope.repository.InventarioRepository;
import dc.hope.repository.PedidosRepository;
import dc.hope.request.PedidoRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class PedidoService {

 
   @Autowired
    PedidosRepository pedidosRepository;

    @Autowired
    InventarioRepository inventarioRepository;

    private final ClienteService clienteService;
    private final OngService ongsService;


        

    public Pedidos salvar (Pedidos pedidos){
        return pedidosRepository.save(pedidos);

    }

    public Pedidos findById(Long id){
        return pedidosRepository.findById(id).orElseThrow(new DefaultException(HttpStatus.BAD_REQUEST, "Pedido não encontrado"));
    }

    public List<Pedidos> findAllById(){
        return pedidosRepository.findAll();
    }

    public void  deletar(Long id){
        var objeto = findById(id);
        pedidosRepository.delete(objeto);
    }

    
    
    public Pedidos abrirPedido(PedidoRequest pedidoRequest){
        Pedidos pedidos = Pedidos.builder()
        .cliente(clienteService.findById(pedidoRequest.getClienteId()))
        .ong(ongsService.findById(pedidoRequest.getOngId()))
        .data(LocalDate.now())
        .forma_pagamento(pedidoRequest.getFormaPagamento())
        .build();
        return pedidosRepository.save(pedidos);
    }

    public String fecharPedido(Long idPedido) {
        Pedidos pedido = findById(idPedido);
        if(pedido.isPedido_fechado()){throw new DefaultException(HttpStatus.BAD_REQUEST, "Este pedido já está fechado e não pode mais ser alterado");};
        if(pedido.getProdutos().isEmpty()){throw new DefaultException(HttpStatus.BAD_REQUEST, "Este pedido não contém produtos, não pode ser fechado");}
        pedido.setPedido_fechado(true);
        pedidosRepository.save(pedido);
        List<String> mensagem = new ArrayList<>();
        mensagem.add("Ficamos muito contentes com sua compra, "+pedido.getCliente().getNome());
        mensagem.add("Seu Id de pedido é: "+pedido.getId());
        mensagem.add("Estes são os itens em seu pedido");
        for (Produtos produto : pedido.getProdutos()) {
            ChaveProdutoPedido chave = new ChaveProdutoPedido(pedido.getId(), produto.getId());
            mensagem.add("Item: "+produto.getNome());
            mensagem.add("Preço unitário: "+produto.getPreco());
            mensagem.add("Valor unitário convertido em doação: "+produto.getDoacao());
            mensagem.add("Quantidade: "+inventarioRepository.findById(chave).get().getQuantidade());
        }
        mensagem.add("O valor total do seu pedido é: "+pedido.getValor_total());
        mensagem.add("Com essa compra, você gerou "+pedido.getValor_doacao()+" para a Ong "+pedido.getOng().getNome());
        mensagem.add("Você escolheu pagar utilizando "+pedido.getForma_pagamento());
        return mensagem.toString();
    }

    public Pedidos adicionarValorProduto(Pedidos pedido, Produtos produto, int quantidade){
        double valortotal = pedido.getValor_total();
        double valordoacao = pedido.getValor_doacao();
        pedido.setValor_total(valortotal + produto.getPreco()*quantidade);
        pedido.setValor_doacao(valordoacao + produto.getPreco()*produto.getDoacao()*quantidade);
        return pedidosRepository.save(pedido);
    
    
    }
    

        public Pedidos removerValorProduto(Pedidos pedido, Produtos produto, int quantidade){
            double valortotal = pedido.getValor_total();
            double valordoacao = pedido.getValor_doacao();
            pedido.setValor_total(valortotal - produto.getPreco()*quantidade);
            pedido.setValor_doacao(valordoacao - produto.getPreco()*produto.getDoacao()*quantidade);
            return pedidosRepository.save(pedido);
        
        
        }


        public Pedidos checarPedidoFechadoERetornar(Long idPedido){
            if(findById(idPedido).isPedido_fechado()){throw new DefaultException(HttpStatus.BAD_REQUEST, "Este pedido já está fechado e não pode mais ser alterado");}
                else {return findById(idPedido);}}

    }


