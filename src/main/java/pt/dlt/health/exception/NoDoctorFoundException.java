package pt.dlt.health.exception;

public class NoDoctorFoundException extends Throwable {

    private static final long serialVersionUID = 1L;

    public NoDoctorFoundException() {
        super("Não existe um doutor com os parâmetros indicados!");
    }
    
}
