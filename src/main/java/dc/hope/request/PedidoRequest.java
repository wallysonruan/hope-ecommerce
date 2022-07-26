package dc.hope.request;

import java.sql.Date;
import java.time.LocalDate;

import dc.hope.models.Clientes;
import dc.hope.models.Ongs;
import dc.hope.models.Pedidos;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class PedidoRequest {

    private Clientes cliente_id;
    private Ongs ong_id;
    private LocalDate data;
    private String forma_pagamento;
    private double valor_total;
    private double valor_doacao;

    public Pedidos converterClasse(){
        return Pedidos.builder()
        .cliente(this.cliente_id)
        .ong(this.ong_id)
        .data(this.data)
        .forma_pagamento(this.forma_pagamento)
        .valor_total(this.valor_total)
        .valor_doacao(this.valor_doacao)
        .build();
    }
    
}
