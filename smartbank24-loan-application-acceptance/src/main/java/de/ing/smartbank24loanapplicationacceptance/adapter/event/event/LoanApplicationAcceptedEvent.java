package de.ing.smartbank24loanapplicationacceptance.adapter.event.event;


import de.ing.smartbank24loanapplicationacceptance.adapter.dto.LoanApplicationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public class LoanApplicationAcceptedEvent extends BaseEvent{
    private LoanApplicationDTO loanApplicationDTO;
}
