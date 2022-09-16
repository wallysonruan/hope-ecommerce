package dc.hope.request;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ClienteUpdateRequest {

   @CPF(message="O CPF informado não é válido")
    private String cpf;
    
    private String nome;
    
    @Email(message = "O e-mail informado não é válido")
    private String email;
    
   private String telefone;

    public ClienteUpdateRequest (){}
       
    }