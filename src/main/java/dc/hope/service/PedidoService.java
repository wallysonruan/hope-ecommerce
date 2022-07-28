package dc.hope.service;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dc.hope.exceptions.DefaultException;
import dc.hope.models.Pedidos;
import dc.hope.repository.PedidosRepository;
import dc.hope.request.PedidoRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class PedidoService {

 
    private final PedidosRepository pedidosRepository;
    private final ClienteService clienteService;
    private final OngService ongsService;

        

    public Pedidos salvar (Pedidos pedidos){
        return pedidosRepository.save(pedidos);

    }

    public Pedidos findById(Long id){
        return pedidosRepository.findById(id).orElseThrow(new DefaultException(HttpStatus.BAD_REQUEST, "Pedido não encontrado"));
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
      
}
