package dc.hope.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dc.hope.models.Ongs;
import dc.hope.request.OngRequest;
import dc.hope.service.OngService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="ong")
@AllArgsConstructor

public class OngResource {

    private final OngService ongService;

    @PostMapping(path="cadastrar")
    public Ongs cadastarOng(@RequestBody @Valid OngRequest ongRequest){
        return ongService.cadastrar(ongRequest);
    }

    @GetMapping(path="buscar")
    public List<Ongs> Ongs(@RequestParam String nome){

        return ongService.findByName(nome);
        
        
    }
    
    @DeleteMapping(path = "{id}")
        public void deletar(@PathVariable Long id){
            ongService.deletar(id);
    }

    
}
