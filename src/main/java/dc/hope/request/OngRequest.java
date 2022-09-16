package dc.hope.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OngRequest {
   
    @NotNull(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotEmpty(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotBlank(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @CNPJ(message = "O CNPJ informado não é válido")
    private String cnpj;

    @NotNull(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotEmpty(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotBlank(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    private String nome;

    @NotNull(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotEmpty(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotBlank(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @Email(message = "O e-mail informado não é válido")
    private String email;
}
