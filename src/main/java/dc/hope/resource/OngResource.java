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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dc.hope.models.Ong;
import dc.hope.request.OngRequest;
import dc.hope.request.OngUpdateRequest;
import dc.hope.service.OngService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="ong")
@AllArgsConstructor

public class OngResource {

    private final OngService ongService;

    @PostMapping(path="cadastrar")
    public Ong cadastrarOng(@RequestBody @Valid OngRequest ongRequest){
        return ongService.cadastrar(ongRequest);
    }

    @GetMapping(path="buscartodos")
    public List<Ong> buscarTodos(){

        return ongService.findAll();
        
        
    }

    @GetMapping(path="buscar")
    public List<Ong> buscar(@RequestParam String nome){
        return ongService.findByName(nome);      
        
    }
    
    @DeleteMapping(path = "{id}")
        public void deletar(@PathVariable @Valid Long id){
            ongService.deletar(id);
    }

    @PutMapping(path = "{id}")
    public Ong update(@PathVariable @Valid Long id, @RequestBody @Valid OngUpdateRequest ongUpdateRequest){
        return ongService.atualizarOng(id, ongUpdateRequest);
    }

    @GetMapping(path = "{id}")
    public Ong buscarPorId(@PathVariable @Valid Long id){
        Ong ong = ongService.findById(id);
        return ong;
    }
    
}
