package de.ing.smartbank24loanapplicationacceptance.adapter.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanApplicationDTO implements Serializable {

    private static final long serialVersionUID = 8144682724082102640L;


    private UUID creditApplicationId ;

    @NotBlank
    @Size(min = 2, max = 51, message = "please enter at least 2 characters")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 51,  message = "please enter at least 2 characters")
    @NotBlank
    private String lastName;

    @Size(min = 2, max = 51, message = "please enter at least 2 characters")
    @NotBlank
    private String city;

    @Builder.Default
    private LocalDateTime applicationDate = LocalDateTime.now();

    @Min(value = 0)
    @DecimalMin(inclusive = false , message = "cannot be negative or empty (0).", value = "0")
    private double monthlyIncome;
    @Min(value = 0)
    private double monthlyExpenditure;
    @Min(value = 0)
    @DecimalMin(inclusive = false , message = "cannot be negative or empty (0).", value = "0")
    private double creditSum;

}
