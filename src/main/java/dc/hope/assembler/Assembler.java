package dc.hope.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dc.hope.models.Cliente;
import dc.hope.models.Ong;
import dc.hope.models.Produto;
import dc.hope.request.ClienteRequest;
import dc.hope.request.OngRequest;
import dc.hope.request.ProdutoRequest;
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
    
}
