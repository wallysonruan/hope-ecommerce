package dc.hope.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import dc.hope.assembler.Assembler;
import dc.hope.exceptions.DefaultException;
import dc.hope.models.Cliente;
import dc.hope.repository.ClienteRepository;
import dc.hope.request.ClienteRequest;
import dc.hope.request.ClienteUpdateRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final Assembler assembler;

    public Cliente cadastrar (ClienteRequest clienteRequest){
        return clienteRepository.save(assembler.clienteToModel(clienteRequest));
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id).orElseThrow(new DefaultException(HttpStatus.BAD_REQUEST, "Pessoa cliente nao encontrada"));
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente atualizarClientes(Long id, ClienteUpdateRequest clienteUpdateRequest){
    Cliente cliente = findById(id);
    Cliente clienteUpdated =  assembler.atualizarCliente(clienteUpdateRequest, cliente);
    return clienteRepository.save(clienteUpdated);
    }

    public void  deletar(Long id){
        clienteRepository.deleteById(id);;
    }

    
}
