package de.ing.smartbank24loanapplicationstore.domain;

public class LoanApplicationServiceException extends Exception {

    public LoanApplicationServiceException() {
    }

    public LoanApplicationServiceException(String message) {
        super(message);
    }

    public LoanApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoanApplicationServiceException(Throwable cause) {
        super(cause);
    }

    public LoanApplicationServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
