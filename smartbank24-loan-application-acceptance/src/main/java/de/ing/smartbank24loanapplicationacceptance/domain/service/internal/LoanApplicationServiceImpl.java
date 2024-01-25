package de.ing.smartbank24loanapplicationacceptance.domain.service.internal;


import de.ing.smartbank24loanapplicationacceptance.domain.model.LoanApplication;
import de.ing.smartbank24loanapplicationacceptance.domain.repository.LoanApplicationRepository;
import de.ing.smartbank24loanapplicationacceptance.domain.service.LoanApplicationQueryService;
import de.ing.smartbank24loanapplicationacceptance.domain.service.LoanApplicatonCommandService;
import lombok.RequiredArgsConstructor;


import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

public class LoanApplicationServiceImpl implements LoanApplicationQueryService, LoanApplicatonCommandService {

    private final LoanApplicationRepository repo;

    @Override
    public Optional<LoanApplication> findLoanApplivationById(final UUID id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<LoanApplication> findAllLoanApplications() {
        return repo.findAll();
    }

    @Override
    public void accept(final LoanApplication application) {
           repo.create(application);
    }
}
