package dc.hope.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dc.hope.models.Clientes;
import dc.hope.repository.ClienteRepository;
import dc.hope.request.ClienteRequest;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Clientes cadastrar (ClienteRequest clienteRequest){
        Clientes cliente = Clientes.builder()
        .nome(clienteRequest.getNome())
        .cpf(clienteRequest.getCpf())
        .email(clienteRequest.getEmail())
        .build();
        return clienteRepository.save(cliente);
    }

    public Clientes findById(Long id){
        return clienteRepository.findById(id).get();
    }

    public List<Clientes> findAllById(){
        return clienteRepository.findAll();
    }

    
}
