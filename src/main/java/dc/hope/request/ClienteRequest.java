package dc.hope.request;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ClienteRequest {

    @NotNull(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    @NotEmpty(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    @NotBlank(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    @CPF(message="O CPF informado não é válido")
    private String cpf;
   
    @NotNull(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    @NotEmpty(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    @NotBlank(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    private String nome;
    
    @NotNull(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    @NotEmpty(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    @NotBlank(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    @Email(message = "O e-mail informado não é válido")
    private String email;
    
    @NotNull(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    @NotEmpty(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    @NotBlank(message = "Para cadastro de novas pessoas clientes, é preciso preencher CPF, Nome, E-mail e Telefone")
    private String telefone;
       
    }