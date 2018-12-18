package puissance4;

public class IndiceIncorrectException extends Exception {
    public IndiceIncorrectException() {
        super();
    }

    public IndiceIncorrectException(String message) {
        super(message);
    }

    public IndiceIncorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndiceIncorrectException(Throwable cause) {
        super(cause);
    }

    protected IndiceIncorrectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}