package dc.hope.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PedidoRequest {

    private Long cliente_id;
    private Long ong_id;
    private String forma_pagamento;
    private List<Long> produtos_id;

    
}
