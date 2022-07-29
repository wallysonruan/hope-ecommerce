package dc.hope.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OngRequest {
   
    @NotNull(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotEmpty(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotBlank(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    private String cnpj;

    @NotNull(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotEmpty(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotBlank(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    private String nome;

    @NotNull(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotEmpty(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    @NotBlank(message = "Para cadastro de novas ongs, é preciso preencher CNPJ, Nome e E-mail")
    private String email;
}
