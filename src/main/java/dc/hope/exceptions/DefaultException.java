package dc.hope.exceptions;

import java.util.function.Supplier;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DefaultException extends RuntimeException implements Supplier<DefaultException> {

    private static final long serialVersionUID = 1L;
    public HttpStatus httpStatus;
    public String mensagem;


    public ErrorResponse getErrorResponse(){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCodigo(String.valueOf(httpStatus.value()));
        errorResponse.setMensagem(mensagem);
        return errorResponse;

    }

    @Override
    public DefaultException get(){
        return this;
    }


    
}
