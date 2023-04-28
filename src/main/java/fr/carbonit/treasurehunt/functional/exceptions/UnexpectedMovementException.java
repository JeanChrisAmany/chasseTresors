package fr.carbonit.treasurehunt.functional.exceptions;

public class UnexpectedMovementException extends ProgramException {
    public UnexpectedMovementException() {
        super();
    }

    public UnexpectedMovementException(String message) {
        super(message);
    }

    public UnexpectedMovementException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnexpectedMovementException(Throwable cause) {
        super(cause);
    }

    protected UnexpectedMovementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
