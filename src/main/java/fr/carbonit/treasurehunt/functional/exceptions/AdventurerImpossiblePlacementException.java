package fr.carbonit.treasurehunt.functional.exceptions;

public class AdventurerImpossiblePlacementException extends ProgramException {
    public AdventurerImpossiblePlacementException() {
        super();
    }

    public AdventurerImpossiblePlacementException(String message) {
        super(message);
    }

    public AdventurerImpossiblePlacementException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdventurerImpossiblePlacementException(Throwable cause) {
        super(cause);
    }

    protected AdventurerImpossiblePlacementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
