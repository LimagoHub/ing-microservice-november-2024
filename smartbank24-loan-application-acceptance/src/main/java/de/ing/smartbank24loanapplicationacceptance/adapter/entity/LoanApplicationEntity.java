package de.ing.smartbank24loanapplicationacceptance.adapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

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
public class LoanApplicationEntity {

    @Id
    @Column(nullable = false)
    private UUID creditApplicationId ;


    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false)
    private String city;


    private LocalDateTime applicationDate;


    private double monthlyIncome;

    private double monthlyExpenditure;

    private double creditSum;


    // Optimized for Hibernate Caching
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
