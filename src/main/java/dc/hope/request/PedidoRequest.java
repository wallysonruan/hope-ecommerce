package dc.hope.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PedidoRequest {

    @NotNull(message = "Para abrir um pedido, é preciso Id do Cliente, Id da Ong e forma de pagamento")
    private Long clienteId;

    @NotNull(message = "Para abrir um pedido, é preciso Id do Cliente, Id da Ong e forma de pagamento")
    private Long ongId;

    @NotNull(message = "Para abrir um pedido, é preciso Id do Cliente, Id da Ong e forma de pagamento")
    @NotEmpty(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotBlank(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    private String formaPagamento;
  
    
}
