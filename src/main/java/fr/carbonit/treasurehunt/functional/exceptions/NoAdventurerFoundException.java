package fr.carbonit.treasurehunt.functional.exceptions;

public class NoAdventurerFoundException extends ProgramException {

    public NoAdventurerFoundException() {
        super();
    }

    public NoAdventurerFoundException(String message) {
        super(message);
    }

    public NoAdventurerFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAdventurerFoundException(Throwable cause) {
        super(cause);
    }

    protected NoAdventurerFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
