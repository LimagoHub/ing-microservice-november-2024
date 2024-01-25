package de.ing.smartbank24loanapplicationstore.adapter.mapper;



import de.ing.smartbank24loanapplicationstore.adapter.repositories.entities.LoanApplicationEntity;
import de.ing.smartbank24loanapplicationstore.domain.aggregate.LoanApplication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanApplicationMapper {
    LoanApplication convert(LoanApplicationEntity loanApplicationEntity);
    LoanApplicationEntity convert(LoanApplication loanApplication);

    Iterable<LoanApplication> convert(Iterable<LoanApplicationEntity> antraege);
}
