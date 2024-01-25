package de.ing.smartbank24loanapplicationacceptance.domain.service;

public class LoanApplicationServiceException extends RuntimeException{
    public LoanApplicationServiceException() {
    }

    public LoanApplicationServiceException(final String message) {
        super(message);
    }

    public LoanApplicationServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public LoanApplicationServiceException(final Throwable cause) {
        super(cause);
    }

    public LoanApplicationServiceException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
