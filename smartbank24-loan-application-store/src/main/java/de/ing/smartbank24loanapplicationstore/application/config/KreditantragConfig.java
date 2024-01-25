package de.ing.smartbank24loanapplicationstore.application.config;


import de.ing.smartbank24loanapplicationstore.domain.LoanApplicationRepository;
import de.ing.smartbank24loanapplicationstore.domain.LoanApplicationService;
import de.ing.smartbank24loanapplicationstore.domain.event.LocalEventPublisher;
import de.ing.smartbank24loanapplicationstore.domain.internal.LoanApplicationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KreditantragConfig {

    @Bean
    public LoanApplicationService createKreditantragService(LoanApplicationRepository repo, LocalEventPublisher publisher) {
        return new LoanApplicationServiceImpl(repo, publisher);
    }
}
