package dc.hope.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dc.hope.models.Inventario;
import dc.hope.repository.InventarioRepository;
import dc.hope.request.InventarioRequest;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service

public class InventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    public Inventario salvar (InventarioRequest inventarioRequest){
        Inventario inventarioDb = inventarioRequest.converterClasse();
        inventarioRepository.save(inventarioDb);
        return inventarioDb;

    }
    
}
