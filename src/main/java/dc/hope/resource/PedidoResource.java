package dc.hope.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dc.hope.models.Pedidos;
import dc.hope.request.PedidoRequest;
import dc.hope.service.PedidoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "pedido")
@AllArgsConstructor
public class PedidoResource {

  private final PedidoService pedidoService;

  @PostMapping(path="abrirPedido")
  public Pedidos abrirPedido(@RequestBody PedidoRequest pedidoRequest){

     return pedidoService.salvar(pedidoRequest);
  }
  
}
