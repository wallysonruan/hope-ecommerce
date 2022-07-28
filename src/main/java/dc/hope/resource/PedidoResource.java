package dc.hope.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dc.hope.models.Pedidos;
import dc.hope.request.PedidoRequest;
import dc.hope.service.PedidoService;

@RestController
@RequestMapping(value = "pedido")
public class PedidoResource {

  @Autowired
  PedidoService pedidoService;

  @PostMapping(path="abrirPedido")
  public Pedidos abrirPedido(@RequestBody PedidoRequest pedidoRequest){

     return pedidoService.abrirPedido(pedidoRequest);
  }
  

  @GetMapping(value="busca")
  public Pedidos buscaPedidos(@RequestParam Long idPedido){
    return pedidoService.findById(idPedido);
  }
}
