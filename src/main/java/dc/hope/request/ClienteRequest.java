package dc.hope.request;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ClienteRequest {

    private String cpf;
    private String nome;
    private String email;
    private String telefone;
       
    }