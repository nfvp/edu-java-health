package pt.dlt.health.exception;

public class NoSlotsAvailableException extends Throwable {

    private static final long serialVersionUID = 1L;

    public NoSlotsAvailableException() {
        super("Não há vagas disponíveis!");
    }
    
}
