package pt.dlt.health.exception;

public class NoAppointmentFoundException extends Throwable {

    private static final long serialVersionUID = 1L;

    public NoAppointmentFoundException() {
        super("Não existe uma consulta com os parâmetros indicados!");
    }
    
}
