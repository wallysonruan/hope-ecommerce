package dc.hope.request;

import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OngUpdateRequest {
   
    @CNPJ(message = "O CNPJ informado não é válido")
    private String cnpj;

    private String nome;

    @Email(message = "O e-mail informado não é válido")
    private String email;
}
