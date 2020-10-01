package be.abis.exc2.exception;



public class SalaryTooLowException extends Exception {
    public SalaryTooLowException() {
        super();
    }

    public SalaryTooLowException(String message) {
        super(message);
    }

    public SalaryTooLowException(String message, Throwable cause) {
        super(message, cause);
    }

    public SalaryTooLowException(Throwable cause) {
        super(cause);
    }

    protected SalaryTooLowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
