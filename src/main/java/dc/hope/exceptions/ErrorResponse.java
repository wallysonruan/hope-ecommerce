package dc.hope.exceptions;

import java.io.Serializable;

import lombok.Data;

@Data
public class ErrorResponse implements Serializable{

    private static final long serialVersionUID = 1L;
    private String codigo;
    private String mensagem;
   
}
