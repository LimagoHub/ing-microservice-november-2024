package de.ing.smartbank24loanapplicationstore.domain.event;


import de.ing.smartbank24loanapplicationstore.domain.aggregate.LoanApplication;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanApplicationDeniedLocalEvent {

    private LoanApplication loanApplication;
}
