package dc.hope.assembler;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import dc.hope.models.Cliente;
import dc.hope.models.Ong;
import dc.hope.models.Produto;
import dc.hope.request.ClienteRequest;
import dc.hope.request.ClienteUpdateRequest;
import dc.hope.request.OngRequest;
import dc.hope.request.OngUpdateRequest;
import dc.hope.request.ProdutoRequest;
import dc.hope.request.ProdutoUpdateRequest;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor


public class Assembler {

    private final ModelMapper modelMapper;

    public Cliente clienteToModel(ClienteRequest clienteRequest){
        return modelMapper.map(clienteRequest, Cliente.class);
    }

    public Ong ongToModel(OngRequest ongRequest){
        return modelMapper.map(ongRequest, Ong.class);
    }

    public Produto produtoToModel(ProdutoRequest produtoRequest){

        return modelMapper.map(produtoRequest, Produto.class);
    }
    
    public Cliente clienteUpdateToModel(ClienteUpdateRequest clienteUpdateRequest){
        return modelMapper.map(clienteUpdateRequest, Cliente.class);
    }

    public Cliente atualizarCliente(ClienteUpdateRequest clienteUpdateRequest, Cliente clienteToUpdate){
        this.modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Cliente clienteUpdate = clienteUpdateToModel(clienteUpdateRequest);
        modelMapper.map(clienteUpdate, clienteToUpdate);
        return clienteToUpdate;    
    }

    public Produto ProdutoUpdateToModel(ProdutoUpdateRequest produtoUpdateRequest){
        return modelMapper.map(produtoUpdateRequest, Produto.class);
    }
    
    public Produto atualizarProduto(ProdutoUpdateRequest produtoUpdateRequest, Produto produtoToUpdate){
        this.modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Produto produtoUpdate = ProdutoUpdateToModel(produtoUpdateRequest);
        modelMapper.map(produtoUpdate, produtoToUpdate);
        return produtoToUpdate;    
    }

    public Ong OngUpdateToModel(OngUpdateRequest ongUpdateRequest){
        return modelMapper.map(ongUpdateRequest, Ong.class);
    }
    
    public Ong atualizarOng(OngUpdateRequest OngUpdateRequest, Ong OngToUpdate){
        this.modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Ong ongUpdate = OngUpdateToModel(OngUpdateRequest);
        modelMapper.map(ongUpdate, OngToUpdate);
        return OngToUpdate;    
    }
}
