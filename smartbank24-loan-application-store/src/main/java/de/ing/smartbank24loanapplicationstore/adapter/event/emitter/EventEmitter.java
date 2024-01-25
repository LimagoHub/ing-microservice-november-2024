package de.ing.smartbank24loanapplicationstore.adapter.event.emitter;


import de.ing.smartbank24loanapplicationstore.adapter.mapper.LoanApplicationLocalEventToDomainEventMapper;
import de.ing.smartbank24loanapplicationstore.domain.event.LoanApplicationAcceptedLocalEvent;
import de.ing.smartbank24loanapplicationstore.domain.event.LoanApplicationDeniedLocalEvent;
import de.ing.smartbank24loanapplicationstore.domain.event.LoanApplicationPersistiertLocalEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventEmitter {

    private static final String SUPPLIER_BINDING_NAME_PERSISTIERT = "loanApplicationPersisted-out-0";
    private static final String SUPPLIER_BINDING_NAME_EMPFOHLEN = "contractAccepted-out-0";
    private static final String SUPPLIER_BINDING_NAME_ABGELEHNT = "contractDenied-out-0";
    private final StreamBridge bridge;
    private final LoanApplicationLocalEventToDomainEventMapper mapper;

    @EventListener
    public void handle(LoanApplicationPersistiertLocalEvent event){
        bridge.send(SUPPLIER_BINDING_NAME_PERSISTIERT, mapper.convert(event));
    }
    @EventListener
    public void handle(LoanApplicationAcceptedLocalEvent event){
        bridge.send(SUPPLIER_BINDING_NAME_EMPFOHLEN, mapper.convert(event));
    }
    @EventListener
    public void handle(LoanApplicationDeniedLocalEvent event){
        bridge.send(SUPPLIER_BINDING_NAME_ABGELEHNT, mapper.convert(event));
    }
}
