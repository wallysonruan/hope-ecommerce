package dc.hope.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProdutoRequest {

    @NotNull(message = "Para cadastro de novos produtos, é preciso preencher Nome, Estoque, Preço e proporção do valor doado")
    @NotEmpty(message = "Para cadastro de novos produtos, é preciso preencher Nome, Estoque, Preço e proporção do valor doado")
    @NotBlank(message = "Para cadastro de novos produtos, é preciso preencher Nome, Estoque, Preço e proporção do valor doado")
    private String nome;

    @NotNull(message = "Para cadastro de novos produtos, é preciso preencher Nome, Estoque, Preço e proporção do valor doado")
    @PositiveOrZero
    private int estoque;

    @NotNull(message = "Para cadastro de novos produtos, é preciso preencher Nome, Estoque, Preço e proporção do valor doado")
    @Positive(message = "Para cadastro de novos produtos, é preciso preencher Nome, Estoque, Preço e proporção do valor doado")
    private double preco;

    @Positive(message = "Para cadastro de novos produtos, é preciso preencher Nome, Estoque, Preço e proporção do valor doado")
    @NotNull(message = "Para cadastro de novos produtos, é preciso preencher Nome, Estoque, Preço e proporção do valor doado")
    private double doacao;
   
}
