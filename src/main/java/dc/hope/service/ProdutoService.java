package dc.hope.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dc.hope.assembler.Assembler;
import dc.hope.exceptions.DefaultException;
import dc.hope.models.Produtos;
import dc.hope.repository.ProdutosRepository;
import dc.hope.request.ProdutoRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProdutoService {

    
    private final ProdutosRepository produtosRepository;
    private final Assembler assembler;


    public List<Produtos> findByName(String nome){
       return produtosRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public Produtos findById(Long id){
        return produtosRepository.findById(id).orElseThrow(new DefaultException(HttpStatus.NO_CONTENT, "Produto não encontrado"));
    }

    public List<Produtos> findAll(){
        return produtosRepository.findAll();
    }

    public Produtos cadastrar (ProdutoRequest produtoRequest){
        return produtosRepository.save(assembler.produtoToModel(produtoRequest));
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

    public void  deletar(Long id){
        var objeto = findById(id);
        produtosRepository.delete(objeto);
    }

    public List<Produtos> ordernaProdutosMenorValor(String nome){
        return produtosRepository.findByNomeContainingIgnoreCaseOrderByPrecoAsc(nome);
    }

    public List<Produtos> ordernaProdutosMaiorValor(String nome){
        return produtosRepository.findByNomeContainingIgnoreCaseOrderByPrecoDesc(nome);
    }


}
