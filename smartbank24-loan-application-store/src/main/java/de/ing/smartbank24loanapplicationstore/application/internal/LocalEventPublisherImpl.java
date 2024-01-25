package de.ing.smartbank24loanapplicationstore.application.internal;


import de.ing.smartbank24loanapplicationstore.domain.event.LoanApplicationAcceptedLocalEvent;
import de.ing.smartbank24loanapplicationstore.domain.event.LoanApplicationDeniedLocalEvent;
import de.ing.smartbank24loanapplicationstore.domain.event.LoanApplicationPersistiertLocalEvent;
import de.ing.smartbank24loanapplicationstore.domain.event.LocalEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocalEventPublisherImpl implements LocalEventPublisher {

    private final ApplicationEventPublisher publisher;

    @Override
    public void sende(LoanApplicationPersistiertLocalEvent event) {
        publisher.publishEvent(event);
    }

    @Override
    public void sende(LoanApplicationAcceptedLocalEvent event) {
        publisher.publishEvent(event);
    }

    @Override
    public void sende(LoanApplicationDeniedLocalEvent event) {
        publisher.publishEvent(event);
    }
}
