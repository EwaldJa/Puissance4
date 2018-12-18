package puissance4;

public class ColonnePleineException extends Exception {
    public ColonnePleineException() {
        super();
    }

    public ColonnePleineException(String message) {
        super(message);
    }

    public ColonnePleineException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColonnePleineException(Throwable cause) {
        super(cause);
    }

    protected ColonnePleineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
