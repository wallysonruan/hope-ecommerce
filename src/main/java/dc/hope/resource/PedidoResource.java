package dc.hope.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dc.hope.models.Pedido;
import dc.hope.request.PedidoRequest;
import dc.hope.service.PedidoService;

@RestController
@RequestMapping(value = "pedido")
public class PedidoResource {

  @Autowired
  PedidoService pedidoService;

  @PostMapping(path="abrir")
  public Pedido abrirPedido(@RequestBody @Valid PedidoRequest pedidoRequest){

     return pedidoService.abrirPedido(pedidoRequest);
  }
  
  @GetMapping(path = "buscartodos")
  public List<Pedido> buscartodos(){
    return pedidoService.findAllById();
  }

  @GetMapping(value="buscar/{idPedido}")
  public Pedido buscaPedidos(@PathVariable  Long idPedido){
    return pedidoService.findById(idPedido);
  }

  @PatchMapping(value="fechar/{idPedido}")
  public String fecharpedido(@PathVariable Long idPedido){
    return pedidoService.fecharPedido(idPedido);
  }

  @DeleteMapping(path = "{id}")
        public void deletar(@PathVariable Long id){
            pedidoService.deletar(id);
    }
}
