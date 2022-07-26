package dc.hope.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dc.hope.models.Pedidos;
import dc.hope.repository.PedidosRepository;
import dc.hope.request.PedidoRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class PedidoService {

    @Autowired
    PedidosRepository pedidosRepository;

    

    public Pedidos salvar (PedidoRequest pedidoRequest){
        Pedidos pedidoDb = pedidoRequest.converterClasse();
        pedidosRepository.save(pedidoDb);
        return pedidoDb;
    }

    public Pedidos abrirPedido(PedidoRequest pedidoRequest){
       Pedidos pedidoAberto = pedidoRequest.converterClasse();
        return pedidoAberto;
    }
    
}
