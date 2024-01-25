package de.ing.smartbank24loanapplicationacceptance.adapter.event.emitter;


import de.ing.smartbank24loanapplicationacceptance.adapter.event.event.LoanApplicationAcceptedEvent;
import de.ing.smartbank24loanapplicationacceptance.adapter.mapper.LoanApplicationDTOMapper;
import de.ing.smartbank24loanapplicationacceptance.domain.model.LoanApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventEmitter {

    private static final String SUPPLIER_BINDIN_NAME = "loan-application-accepted-out-0";
    private final StreamBridge bridge;
    private final LoanApplicationDTOMapper mapper;

    @EventListener // Eventlistener for inner Spring events
    public void send(LoanApplication loanApplication) {
        // Fire extern event
        System.out.println("Eventlistener");
        bridge.send(SUPPLIER_BINDIN_NAME, new LoanApplicationAcceptedEvent(mapper.convert(loanApplication)));
    }

}
