package dc.hope.resource;

import org.springframework.web.bind.annotation.RestController;

import dc.hope.models.ChaveProdutoPedido;
import dc.hope.models.Inventario;
import dc.hope.models.Pedidos;
import dc.hope.request.InventarioRequest;
import dc.hope.service.InventarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping (value="inventario")

public class InventarioResource {

    @Autowired
    InventarioService inventarioService;

    @PostMapping(path="add")
    public Pedidos addproduto(@RequestBody InventarioRequest inventarioRequest){


        return inventarioService.addProduto(inventarioRequest);

       }
    
    @GetMapping(path="busca")
    public Inventario buscaInventario(@RequestBody ChaveProdutoPedido chave){
        
        return inventarioService.findById(chave);
    }    

    @PatchMapping(path="remover")
    public Pedidos removePedidos(@RequestBody InventarioRequest inventarioRequest){
        return inventarioService.removeProduto(inventarioRequest);
    }
}