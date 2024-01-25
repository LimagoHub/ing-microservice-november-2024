package de.ing.smartbank24loanapplicationacceptance.application;


import de.ing.smartbank24loanapplicationacceptance.domain.model.LoanApplication;

public interface LoanApplicationHandler {
    void handle(LoanApplication loanApplication);
}
