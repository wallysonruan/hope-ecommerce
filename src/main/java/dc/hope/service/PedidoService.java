package dc.hope.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import dc.hope.models.Clientes;
import dc.hope.models.Ongs;
import dc.hope.models.Pedidos;
import dc.hope.models.Produtos;
import dc.hope.repository.PedidosRepository;
import dc.hope.request.PedidoRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class PedidoService {

 
    private PedidosRepository pedidosRepository;

    private ProdutoService produtoService;
    
    private ClienteService clienteService;
    
    private OngService ongsService;
        

    public Pedidos salvar (Pedidos pedidos){
        return pedidosRepository.save(pedidos);

    }

    public Pedidos findById(Long id){
        return pedidosRepository.findById(id).get();
    }
    
    public Pedidos addProduto(Long idPedido, Long idProduto){
        Pedidos pedido = findById(idPedido);
        Produtos produto = produtoService.findById(idProduto);
        pedido.addProduto(produto);
        return pedidosRepository.save(pedido);
    }

    public Ongs ong(Long id){
        Ongs ong = ongsService.findById(id);
        return ong;
    }
    
    public Clientes cliente(Long id){
        return clienteService.findById(id);
    }
     
    public Pedidos abrirPedido(PedidoRequest pedidoRequest){
        Pedidos pedidos = Pedidos.builder()
        .cliente(clienteService.findById(pedidoRequest.getCliente_id()))
        .ong(ongsService.findById(pedidoRequest.getOng_id()))
        .data(LocalDate.now())
        .forma_pagamento(pedidoRequest.getForma_pagamento())
        .build();
        return pedidosRepository.save(pedidos);
    }
      
}
