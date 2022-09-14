package dc.hope.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dc.hope.assembler.Assembler;
import dc.hope.exceptions.DefaultException;
import dc.hope.models.Produto;
import dc.hope.repository.ProdutosRepository;
import dc.hope.request.ProdutoRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProdutoService {

    
    private final ProdutosRepository produtosRepository;
    private final Assembler assembler;


    public List<Produto> findByName(String nome){
       return produtosRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public Produto findById(Long id){
        return produtosRepository.findById(id).orElseThrow(new DefaultException(HttpStatus.NO_CONTENT, "Produto não encontrado"));
    }

    public List<Produto> findAll(){
        return produtosRepository.findAll();
    }

    public Produto cadastrar (ProdutoRequest produtoRequest){
        return produtosRepository.save(assembler.produtoToModel(produtoRequest));
    }
    
    public Produto salvar (Produto produto){
        return produtosRepository.save(produto);
    }

    public Produto removerEstoque(Produto produto, int quantidade){
        int estoque = produto.getEstoque();
        produto.setEstoque(estoque - quantidade);
        return produtosRepository.save(produto);
    }

    public Produto reporEstoque(Produto produto, int quantidade){
        int estoque = produto.getEstoque();
        produto.setEstoque(estoque + quantidade);
        return produtosRepository.save(produto);
    }

    public void  deletar(Long id){
        var objeto = findById(id);
        produtosRepository.delete(objeto);
    }

    public List<Produto> ordernaProdutosMenorValor(String nome){
        return produtosRepository.findByNomeContainingIgnoreCaseOrderByPrecoAsc(nome);
    }

    public List<Produto> ordernaProdutosMaiorValor(String nome){
        return produtosRepository.findByNomeContainingIgnoreCaseOrderByPrecoDesc(nome);
    }


}
