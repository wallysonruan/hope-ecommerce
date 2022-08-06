package dc.hope.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dc.hope.assembler.Assembler;
import dc.hope.exceptions.DefaultException;
import dc.hope.models.Clientes;
import dc.hope.repository.ClienteRepository;
import dc.hope.request.ClienteRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final Assembler assmebler;

    public Clientes cadastrar (ClienteRequest clienteRequest){
        return clienteRepository.save(assmebler.clienteToModel(clienteRequest));
    }

    public Clientes findById(Long id){
        return clienteRepository.findById(id).orElseThrow(new DefaultException(HttpStatus.BAD_REQUEST, "Pessoa cliente nao encontrada"));
    }

    public List<Clientes> findAllById(){
        return clienteRepository.findAll();
    }

    public Clientes atualizarClientes(Long id, ClienteRequest clienteRequest){

        var entity = findById(id);
        BeanUtils.copyProperties(clienteRequest, entity,"id");
        return clienteRepository.save(entity);
    }

    
}
