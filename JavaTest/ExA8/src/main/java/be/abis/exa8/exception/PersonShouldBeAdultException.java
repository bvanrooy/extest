package be.abis.exa8.exception;

public class PersonShouldBeAdultException extends Exception {

    public PersonShouldBeAdultException() {
        super();
    }

    public PersonShouldBeAdultException(String message) {
        super(message);
    }

    public PersonShouldBeAdultException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonShouldBeAdultException(Throwable cause) {
        super(cause);
    }

    protected PersonShouldBeAdultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
