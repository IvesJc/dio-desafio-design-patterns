package one.digitalinnovation.gof.infra.handler;

import one.digitalinnovation.gof.exceptions.ClienteNotFoundException;
import one.digitalinnovation.gof.exceptions.EnderecoNotFoundException;
import one.digitalinnovation.gof.infra.JsonExceptionConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<JsonExceptionConfig> clienteNotFoundExceptionHandler(ClienteNotFoundException e){

        JsonExceptionConfig exceptionMessage = new JsonExceptionConfig(
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionMessage);
    }

    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<JsonExceptionConfig> enderecoNotFoundExceptionHandler(EnderecoNotFoundException e){

        JsonExceptionConfig exceptionMessage = new JsonExceptionConfig(
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionMessage);
    }
}
