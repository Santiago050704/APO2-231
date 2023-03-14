package exceptions;

public class InvalidNumberException extends RuntimeException{
    public InvalidNumberException(){
        super("El número de teléfono no es válido.");
    }
}
