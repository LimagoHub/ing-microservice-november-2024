package de.ing.smartbank24loanapplicationstore.adapter.mapper;


import de.ing.smartbank24loanapplicationstore.adapter.dto.LoanApplicationDTO;
import de.ing.smartbank24loanapplicationstore.domain.aggregate.LoanApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanApplicationDTOMapper {

    LoanApplicationDTO convert(LoanApplication loanApplication);
    @Mapping(target = "scoringState", ignore = true)
    @Mapping(target = "cityScoringState", ignore = true)
    @Mapping(target = "applicationState", ignore = true)
    LoanApplication convert(LoanApplicationDTO dto);


    Iterable<LoanApplicationDTO> convert(Iterable<LoanApplication> applications);
}
