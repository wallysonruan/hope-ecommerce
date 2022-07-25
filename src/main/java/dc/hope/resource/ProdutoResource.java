package dc.hope.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dc.hope.request.ProdutoRequest;
import dc.hope.service.ProdutoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "produto")
@AllArgsConstructor
public class ProdutoResource {


    private final ProdutoService produtoService;

    @PostMapping
    public void inserirProdutos(@RequestBody ProdutoRequest produtoRequest){
        produtoService.salvar(produtoRequest);
    }
    
}
