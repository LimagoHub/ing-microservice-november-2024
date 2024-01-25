package de.ing.smartbank24loanapplicationacceptance.domain.service;


import de.ing.smartbank24loanapplicationacceptance.domain.model.LoanApplication;

public interface LoanApplicatonCommandService {

    void accept(final LoanApplication application);
}
