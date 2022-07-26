package dc.hope.request;

import dc.hope.models.Ongs;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OngRequest {
   
    private String cnpj;
    private String nome;
    private String email;

    public Ongs converterClasse(){
        return Ongs.builder()
        .cnpj(this.cnpj)
        .nome(this.nome)
        .email(this.email)
        .build();
    }
}
