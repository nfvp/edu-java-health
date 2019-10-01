package pt.dlt.health.exception;

public class NoPatientFoundException extends Throwable {

    private static final long serialVersionUID = 1L;

    public NoPatientFoundException() {
        super("Não existe um paciente com os parâmetros indicados!");
    }
    
}
