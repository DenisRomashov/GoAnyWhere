package ga.goanywhere.exceptions;

public class TooManyParticipantsException extends RuntimeException {

    public TooManyParticipantsException() {
    }

    public TooManyParticipantsException(String message) {
        super(message);
    }
}
