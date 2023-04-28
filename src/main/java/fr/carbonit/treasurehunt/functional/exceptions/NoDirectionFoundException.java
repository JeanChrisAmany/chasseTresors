package fr.carbonit.treasurehunt.functional.exceptions;

public class NoDirectionFoundException extends ProgramException {
    public NoDirectionFoundException() {
        super();
    }

    public NoDirectionFoundException(String message) {
        super(message);
    }

    public NoDirectionFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDirectionFoundException(Throwable cause) {
        super(cause);
    }

    protected NoDirectionFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
