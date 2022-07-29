package dc.hope.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dc.hope.models.Clientes;
import dc.hope.request.ClienteRequest;
import dc.hope.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "cliente")
@AllArgsConstructor
public class ClienteResource {

    private ClienteService clienteService;

    @PostMapping(path="cadastrar")
    public Clientes cadastrarCliente(@RequestBody ClienteRequest clienteRequest){
        return clienteService.salvar(clienteRequest);
    }

    @GetMapping("/{id}")
    public Clientes findById(@PathVariable Long id){
        return clienteService.findById(id);
    }
    
}
