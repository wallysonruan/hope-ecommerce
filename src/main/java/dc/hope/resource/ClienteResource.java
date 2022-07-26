package dc.hope.resource;

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

    private final ClienteService clienteService;

    @PostMapping(path="cadastrar")
    public Clientes cadastrarCliente(@RequestBody ClienteRequest clienteRequest){
        return clienteService.salvar(clienteRequest);
    }

    
}