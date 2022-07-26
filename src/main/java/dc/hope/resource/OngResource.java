package dc.hope.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Ongs cadastarOng(@RequestBody OngRequest ongRequest){
        return ongService.salvar(ongRequest);
    }
    
}
