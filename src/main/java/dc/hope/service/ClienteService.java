package dc.hope.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dc.hope.models.Clientes;
import dc.hope.repository.ClienteRepository;
import dc.hope.request.ClienteRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Clientes salvar (ClienteRequest clienteRequest){
        Clientes clienteDb = clienteRequest.converterClasse();
        clienteRepository.save(clienteDb);
        return clienteDb;
    }
}
