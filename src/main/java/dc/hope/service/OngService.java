package dc.hope.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dc.hope.models.Ongs;
import dc.hope.repository.OngsRepository;
import dc.hope.request.OngRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class OngService {

    @Autowired
    OngsRepository ongsRepository;

    public Ongs salvar (OngRequest ongRequest){

        Ongs ongDb = ongRequest.converterClasse();
        ongsRepository.save(ongDb);
        return ongDb;

    }
    
}
