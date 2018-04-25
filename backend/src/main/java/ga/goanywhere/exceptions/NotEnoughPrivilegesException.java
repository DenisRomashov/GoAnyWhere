package ga.goanywhere.exceptions;

public class NotEnoughPrivilegesException extends RuntimeException {

    public NotEnoughPrivilegesException() {
    }

    public NotEnoughPrivilegesException(String message) {
        super(message);
    }
}
