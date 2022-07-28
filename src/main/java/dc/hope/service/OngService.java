package dc.hope.service;

import java.util.List;

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

    public List<Ongs> findByName(String nome){
        return ongsRepository.findByNomeContainingIgnoreCase(nome);
     }
    
     public Ongs findById(Long id){
        return ongsRepository.findById(id).get();
    }

    public Ongs cadastrar(OngRequest ongRequest){
        Ongs ong = Ongs.builder()
        .nome(ongRequest.getNome())
        .cnpj(ongRequest.getCnpj())
        .email(ongRequest.getEmail())
        .build();
        return ongsRepository.save(ong);
    }
}
