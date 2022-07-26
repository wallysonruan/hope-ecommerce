package dc.hope.request;
import dc.hope.models.Clientes;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ClienteRequest {

    private String cpf;
    private String nome;
    private String email;
    private String telefone;

    public Clientes converterClasse(){

        return Clientes.builder()
        .cpf(this.cpf)
        .nome(this.nome)
        .email(this.email)
        .telefone(this.telefone)
        .build();

        
    }
}