package dc.hope.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dc.hope.exceptions.DefaultException;
import dc.hope.models.Produtos;
import dc.hope.repository.ProdutosRepository;
import dc.hope.request.ProdutoRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProdutoService {

    @Autowired
    ProdutosRepository produtosRepository;


    public List<Produtos> findByName(String nome){
       return produtosRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public Produtos findById(Long id){
        return produtosRepository.findById(id).orElseThrow(new DefaultException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));
    }

    public List<Produtos> findAll(){
        return produtosRepository.findAll();
    }

    public Produtos cadastrar (ProdutoRequest produtoRequest){
        Produtos produto = Produtos.builder()
        .nome(produtoRequest.getNome())
        .estoque(produtoRequest.getEstoque())
        .preco(produtoRequest.getPreco())
        .doacao(produtoRequest.getDoacao())
        .build();
        return produtosRepository.save(produto);
    }
    
    public Produtos salvar (Produtos produto){
        return produtosRepository.save(produto);
    }

    public Produtos removerEstoque(Produtos produto, int quantidade){
        int estoque = produto.getEstoque();
        produto.setEstoque(estoque - quantidade);
        return produtosRepository.save(produto);
    }

    public Produtos reporEstoque(Produtos produto, int quantidade){
        int estoque = produto.getEstoque();
        produto.setEstoque(estoque + quantidade);
        return produtosRepository.save(produto);
    }
}
