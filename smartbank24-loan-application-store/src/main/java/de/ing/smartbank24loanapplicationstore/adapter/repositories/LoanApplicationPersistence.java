package de.ing.smartbank24loanapplicationstore.adapter.repositories;


import de.ing.smartbank24loanapplicationstore.adapter.repositories.entities.LoanApplicationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LoanApplicationPersistence extends CrudRepository<LoanApplicationEntity, UUID> {
}
