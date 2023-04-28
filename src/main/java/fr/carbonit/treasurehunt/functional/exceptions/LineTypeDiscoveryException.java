package fr.carbonit.treasurehunt.functional.exceptions;

public class LineTypeDiscoveryException extends ProgramException {

    public LineTypeDiscoveryException() {
        super();
    }

    public LineTypeDiscoveryException(String message) {
        super(message);
    }

    public LineTypeDiscoveryException(String message, Throwable cause) {
        super(message, cause);
    }

    public LineTypeDiscoveryException(Throwable cause) {
        super(cause);
    }

    protected LineTypeDiscoveryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
