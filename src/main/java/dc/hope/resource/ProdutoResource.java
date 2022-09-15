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

import dc.hope.models.Produto;
import dc.hope.request.ProdutoRequest;
import dc.hope.service.ProdutoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "produto")
@AllArgsConstructor
public class ProdutoResource {


    private final ProdutoService produtoService;

    @PostMapping(path="cadastrar")
    public Produto cadastrarProdutos(@RequestBody @Valid ProdutoRequest produtoRequest){

       return produtoService.cadastrar(produtoRequest);
    }

   @GetMapping(path="buscar")
    public List<Produto> arrayProdutos(@RequestParam String nome){

        return produtoService.findByName(nome);        
        
    }
    
    @DeleteMapping(path = "{id}")
        public void deletar(@PathVariable Long id){
            produtoService.deletar(id);
    }

    @GetMapping(path="ordernar")
    public List<Produto> arrayProdutoOrdenado(@RequestParam String nome,boolean ordem){
        if(ordem){
            return produtoService.ordernaProdutosMenorValor(nome);
        }
        return produtoService.ordernaProdutosMaiorValor(nome);
    }

    


    
}
