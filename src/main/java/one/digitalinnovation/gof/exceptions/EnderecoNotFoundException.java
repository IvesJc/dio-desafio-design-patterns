package one.digitalinnovation.gof.exceptions;

public class EnderecoNotFoundException extends RuntimeException{

    public EnderecoNotFoundException() {
        super("Endereco not found");
    }

    public EnderecoNotFoundException(String message) {
        super(message);
    }
}
