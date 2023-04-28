package fr.carbonit.treasurehunt.functional.exceptions;

public class NoMapSizeDefinitionException extends ProgramException {
    public NoMapSizeDefinitionException() {
        super();
    }

    public NoMapSizeDefinitionException(String message) {
        super(message);
    }

    public NoMapSizeDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMapSizeDefinitionException(Throwable cause) {
        super(cause);
    }

    protected NoMapSizeDefinitionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
