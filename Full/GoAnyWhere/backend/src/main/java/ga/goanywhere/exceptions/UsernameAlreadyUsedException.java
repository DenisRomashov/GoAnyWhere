package ga.goanywhere.exceptions;

public class UsernameAlreadyUsedException extends RuntimeException{

    public UsernameAlreadyUsedException() {
    }

    public UsernameAlreadyUsedException(String message) {
        super(message);
    }
}
