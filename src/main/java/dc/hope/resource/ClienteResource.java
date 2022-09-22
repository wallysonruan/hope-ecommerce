package dc.hope.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dc.hope.models.Cliente;
import dc.hope.request.ClienteRequest;
import dc.hope.request.ClienteUpdateRequest;
import dc.hope.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "cliente")
@AllArgsConstructor
public class ClienteResource {

    private final ClienteService clienteService;

    @PostMapping(path="cadastrar")
    public Cliente cadastrarCliente(@RequestBody @Valid ClienteRequest clienteRequest){
        return clienteService.cadastrar(clienteRequest);
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable @Valid Long id){
        return clienteService.findById(id);
    }

    @GetMapping("/buscartodos")
    public List<Cliente> buscartodos(){
        return clienteService.findAll();
    }

    @PutMapping(path = "{id}")
    public Cliente update(@PathVariable @Valid Long id, @RequestBody @Valid ClienteUpdateRequest clienteUpdateRequest){
        return clienteService.atualizarClientes(id, clienteUpdateRequest);
    }

    @DeleteMapping(path = "{id}")
        public void deletar(@PathVariable @Valid Long id){
            clienteService.deletar(id);
    }
    
}
