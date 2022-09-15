package dc.hope.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dc.hope.assembler.Assembler;
import dc.hope.exceptions.DefaultException;
import dc.hope.models.Ong;
import dc.hope.repository.OngsRepository;
import dc.hope.request.OngRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class OngService {

    private final OngsRepository ongsRepository;
    private final Assembler assembler;

    public List<Ong> findByName(String nome){
        return ongsRepository.findByNomeContainingIgnoreCase(nome);
     }
    
     public Ong findById(Long id){
        return ongsRepository.findById(id).orElseThrow(new DefaultException(HttpStatus.BAD_REQUEST, "Ong nao encontrada"));
    }

    public List<Ong> findAllById(){
        return ongsRepository.findAll();
    }

    public Ong cadastrar(OngRequest ongRequest){
        Ong ong = assembler.ongToModel(ongRequest);
        return ongsRepository.save(ong);
    }

    public void  deletar(Long id){
        var objeto = findById(id);
        ongsRepository.delete(objeto);
    }
}
