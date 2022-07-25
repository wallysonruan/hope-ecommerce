package dc.hope.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dc.hope.models.Produtos;
import dc.hope.repository.ProdutosRepository;
import dc.hope.request.ProdutoRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class ProdutoService {

    @Autowired
    ProdutosRepository produtosRepository;

    public Produtos salvar(ProdutoRequest produtoRequest){

        Produtos produtoDb = produtoRequest.converterClasse();
        produtosRepository.save(produtoDb);
        return produtoDb;
    }
    
}
