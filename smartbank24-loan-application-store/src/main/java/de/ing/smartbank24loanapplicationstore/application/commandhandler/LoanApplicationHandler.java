package de.ing.smartbank24loanapplicationstore.application.commandhandler;


import de.ing.smartbank24loanapplicationstore.domain.aggregate.LoanApplication;

import java.util.UUID;

public interface LoanApplicationHandler {
    void handleKreditantragRegistriert(LoanApplication application);
    void handleScoringPositiv(UUID id);
    void handleScoringNegativ(UUID id);
    void handleCityScoringPositiv(UUID id);
    void handleCityScoringNegativ(UUID id);
}
