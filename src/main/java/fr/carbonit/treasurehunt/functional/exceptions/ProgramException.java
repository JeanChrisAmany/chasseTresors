package fr.carbonit.treasurehunt.functional.exceptions;

public class ProgramException extends Exception {

    public ProgramException() {
        super();
    }

    public ProgramException(String message) {
        super(message);
    }

    public ProgramException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProgramException(Throwable cause) {
        super(cause);
    }

    protected ProgramException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
