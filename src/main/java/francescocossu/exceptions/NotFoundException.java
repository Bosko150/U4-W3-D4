package francescocossu.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("l'evento con l'id " + id + " non è stato trovato");
    }
}
