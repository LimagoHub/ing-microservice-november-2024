package de.ing.smartbank24loanapplicationstore.adapter.repositories.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tbl_loan_application")
public class LoanApplicationEntity implements Serializable {
    private static final long serialVersionUID = 8144682724082102640L;


    @Id

    private UUID creditApplicationId ;

    @Column(length = 51)
    private String firstName;

    @Column(length = 51)
    private String lastName;

    @Column(length = 51)
    private String city;


    private LocalDateTime applicationDate ;


    private double monthlyIncome;

    private double monthlyExpenditure;

    private double creditSum;

    @Column(length = 30)
    private String scoringState;

    @Column(length = 30)
    private String cityScoringState;

    @Column(length = 30)
    private String applicationState;

    @Version
    private LocalDateTime version;
    //private long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LoanApplicationEntity that = (LoanApplicationEntity) o;
        return creditApplicationId != null && Objects.equals(creditApplicationId, that.creditApplicationId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
