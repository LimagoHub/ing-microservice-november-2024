package de.ing.smartbank24loanapplicationstore.application.commandhandler.internal;


import de.ing.smartbank24loanapplicationstore.application.commandhandler.LoanApplicationHandler;
import de.ing.smartbank24loanapplicationstore.domain.LoanApplicationService;
import de.ing.smartbank24loanapplicationstore.domain.LoanApplicationServiceException;
import de.ing.smartbank24loanapplicationstore.domain.aggregate.LoanApplication;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(rollbackFor = LoanApplicationServiceException.class, propagation = Propagation.REQUIRED)
@AllArgsConstructor
@Slf4j
public class LoanApplicationHandlerImpl implements LoanApplicationHandler {



    private final LoanApplicationService service;

    @Override
    public void handleKreditantragRegistriert(LoanApplication application){
        try {
            System.out.println(application);
            service.speichereKreditantrag(application);
        } catch (LoanApplicationServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handleScoringPositiv(UUID id){
        try {
            service.verarbeitePositivesScoring(id);
        } catch (LoanApplicationServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handleScoringNegativ(UUID id){
        try {
            service.verarbeiteNegativesScoring(id);
        } catch (LoanApplicationServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handleCityScoringPositiv(UUID id){
        try {
            service.verarbeitePositivesCityScoring(id);
        } catch (LoanApplicationServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handleCityScoringNegativ(UUID id){
        try {
            service.verarbeiteNegativesCityScoring(id);
        } catch (LoanApplicationServiceException e) {
            throw new RuntimeException(e);
        }
    }
}
