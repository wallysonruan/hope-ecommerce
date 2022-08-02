package dc.hope.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dc.hope.models.Clientes;
import dc.hope.models.Ongs;
import dc.hope.models.Produtos;
import dc.hope.request.ClienteRequest;
import dc.hope.request.OngRequest;
import dc.hope.request.ProdutoRequest;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor


public class Assembler {

    private final ModelMapper modelMapper;

    public Clientes clienteToModel(ClienteRequest clienteRequest){
        return modelMapper.map(clienteRequest, Clientes.class);
    }

    public Ongs ongToModel(OngRequest ongRequest){
        return modelMapper.map(ongRequest, Ongs.class);
    }

    public Produtos produtoToModel(ProdutoRequest produtoRequest){

        return modelMapper.map(produtoRequest, Produtos.class);
    }
    
}
