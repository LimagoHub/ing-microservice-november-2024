package de.ing.smartbank24loanapplicationacceptance.application;


import de.ing.smartbank24loanapplicationacceptance.domain.repository.LoanApplicationRepository;
import de.ing.smartbank24loanapplicationacceptance.domain.service.LoanApplicationQueryService;
import de.ing.smartbank24loanapplicationacceptance.domain.service.LoanApplicatonCommandService;
import de.ing.smartbank24loanapplicationacceptance.domain.service.internal.LoanApplicationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LoanApplicationConfig {


    @Bean
    @Primary
    public LoanApplicatonCommandService createLoanApplicatonCommandService(final LoanApplicationRepository repo){
        return new LoanApplicationServiceImpl(repo);
    }

    @Bean
    public LoanApplicationQueryService createLoanApplicatonQueryService(final LoanApplicationRepository repo){
        return new LoanApplicationServiceImpl(repo);
    }
}
