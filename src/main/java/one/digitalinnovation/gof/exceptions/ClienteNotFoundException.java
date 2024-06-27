package one.digitalinnovation.gof.exceptions;

public class ClienteNotFoundException extends RuntimeException{

    public ClienteNotFoundException() {
        super("Cliente not found");
    }

    public ClienteNotFoundException(String message) {
        super(message);
    }
}
