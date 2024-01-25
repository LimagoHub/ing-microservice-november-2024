package de.ing.smartbank24loanapplicationacceptance.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter(AccessLevel.PRIVATE)
public class LoanApplication {

    private UUID creditApplicationId ;

    private String firstName;

    private String lastName;

    private String city;

    private LocalDateTime applicationDate ;

    private double monthlyIncome;

    private double monthlyExpenditure;

    private double creditSum;

}
