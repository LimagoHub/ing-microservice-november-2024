package de.ing.smartbank24loanapplicationstore.domain.aggregate;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * Rules for recommending a credit agreement:
 *
 * To convert a credit application into a contract, two assessments must succeed. Firstly, the classical scoring must yield a positive result, and secondly, the geographical scoring must also deliver a positive outcome.
 *
 * If both scoring assessments are successful, the contract will be recommended. However, if either of the assessments fails, the contract will be rejected.
 *
 * There is no option to reattempt an assessment. Once either the classical or geographical scoring is determined, the result cannot be overwritten. The same principle applies to the final recommendation – once defined, it cannot be revised.
 *
 */
public class LoanApplication {

    private UUID creditApplicationId ;
    private String firstName;
    private String lastName;
    private String city;
    private LocalDateTime applicationDate ;
    private double monthlyIncome;
    private double monthlyExpenditure;
    private double creditSum;
    private LocalDateTime version;
    @Builder.Default
    private String scoringState ="in progress";

    @Builder.Default
    private String cityScoringState ="in progress";

    @Builder.Default
    private String applicationState ="in progress";

    public StatusChange behandlePositivesScoring() {
        if(! applicationState.equals("in progress")) return StatusChange.NO_CHANGE;
        if(! scoringState.equals("in progress")) return StatusChange.NO_CHANGE;

        if(scoringState.equals("in progress") && cityScoringState.equals("in progress")){
            scoringState = "Ok";
            return StatusChange.NO_CHANGE;
        }

        if(scoringState.equals("in progress") &&  cityScoringState.equals("Ok")){
            scoringState = "Ok";
            applicationState = "Accepted";
            return StatusChange.FINAL;
        }
        return StatusChange.NO_CHANGE;
    }

    public StatusChange behandleNegativesScoring() {
        if(! applicationState.equals("in progress")) return StatusChange.NO_CHANGE;
        if(! scoringState.equals("in progress")) return StatusChange.NO_CHANGE;

        scoringState = "abgelehnt";
        applicationState ="DENIED";
        return StatusChange.FINAL;
    }

    public StatusChange behandlePositivesCityScoring() {
        if(! applicationState.equals("in progress")) return StatusChange.NO_CHANGE;
        if(! cityScoringState.equals("in progress")) return StatusChange.NO_CHANGE;

        if(cityScoringState.equals("in progress") && scoringState.equals("in progress")){
            cityScoringState = "Ok";
            return StatusChange.NO_CHANGE;
        }

        if(cityScoringState.equals("in progress") &&  scoringState.equals("Ok")){
            cityScoringState = "Ok";
            applicationState = "Accepted";
            return StatusChange.FINAL;
        }
        return StatusChange.NO_CHANGE;

    }

    public StatusChange behandleNegativesCityScoring() {

        if(! applicationState.equals("in progress")) return StatusChange.NO_CHANGE;
        if(! cityScoringState.equals("in progress")) return StatusChange.NO_CHANGE;

        cityScoringState = "abgelehnt";
        applicationState ="DENIED";
        return StatusChange.FINAL;

    }

}
