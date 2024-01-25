package de.ing.smartbank24loanapplicationstore.domain;


import de.ing.smartbank24loanapplicationstore.domain.aggregate.LoanApplication;

import java.util.UUID;

public interface LoanApplicationService {


    void speichereKreditantrag(LoanApplication application) throws LoanApplicationServiceException;
    void verarbeitePositivesScoring(UUID id) throws LoanApplicationServiceException;
    void verarbeitePositivesCityScoring(UUID id) throws LoanApplicationServiceException;
    void verarbeiteNegativesScoring(UUID id) throws LoanApplicationServiceException;
    void verarbeiteNegativesCityScoring(UUID id) throws LoanApplicationServiceException;
    LoanApplication findeKreditantragMitId(UUID id) throws LoanApplicationServiceException;
}

