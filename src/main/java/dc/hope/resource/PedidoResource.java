package dc.hope.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

  @PostMapping(path="abrir")
  public Pedidos abrirPedido(@RequestBody @Valid PedidoRequest pedidoRequest){

     return pedidoService.abrirPedido(pedidoRequest);
  }
  

  @GetMapping(value="buscar")
  public Pedidos buscaPedidos(@RequestParam Long idPedido){
    return pedidoService.findById(idPedido);
  }

  @PatchMapping(value="fechar")
  public String fecharpedido(@RequestParam Long idPedido){
    return pedidoService.fecharPedido(idPedido);
  }
}
