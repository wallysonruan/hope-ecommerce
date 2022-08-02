package dc.hope.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dc.hope.models.Produtos;
import dc.hope.request.ProdutoRequest;
import dc.hope.service.ProdutoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "produto")
@AllArgsConstructor
public class ProdutoResource {


    private final ProdutoService produtoService;

    @PostMapping(path="cadastrar")
    public Produtos cadastrarProdutos(@RequestBody @Valid ProdutoRequest produtoRequest){

       return produtoService.cadastrar(produtoRequest);
    }

   @GetMapping(path="buscar")
    public List<Produtos> arrayProdutos(@RequestParam String nome){

        return produtoService.findByName(nome);
        
        
    }  


    
}
