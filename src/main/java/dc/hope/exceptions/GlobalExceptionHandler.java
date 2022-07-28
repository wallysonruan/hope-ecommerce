package dc.hope.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<ErrorResponse> handle(DefaultException defaultException){
        return new ResponseEntity<ErrorResponse>(defaultException.getErrorResponse(), defaultException.httpStatus);
    }
    
}
