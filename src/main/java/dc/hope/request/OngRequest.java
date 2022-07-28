package dc.hope.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OngRequest {
   
    private String cnpj;
    private String nome;
    private String email;

}
