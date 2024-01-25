package de.ing.smartbank24loanapplicationacceptance.adapter.controller;


import de.ing.smartbank24loanapplicationacceptance.adapter.dto.LoanApplicationDTO;
import de.ing.smartbank24loanapplicationacceptance.adapter.mapper.LoanApplicationDTOMapper;
import de.ing.smartbank24loanapplicationacceptance.domain.service.LoanApplicationQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path="/api/v1/loanapplications")
@RequiredArgsConstructor
public class LoanApplicationQueryController {

    private final LoanApplicationDTOMapper mapper;
    private final LoanApplicationQueryService service;

    @Operation(summary = "Get a loan application by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the application",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LoanApplicationDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "application not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "internal server error",
                    content = @Content)})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoanApplicationDTO> findAntragByID(@PathVariable UUID id) {
        return ResponseEntity.of(service.findLoanApplivationById(id).map(mapper::convert));
    }


    @Operation(summary = "find all a loan applications")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LoanApplicationDTO.class)) }),

            @ApiResponse(responseCode = "500", description = "internal server error",
                    content = @Content)})
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<LoanApplicationDTO>> findAll()  {
        return ResponseEntity.ok(mapper.convert(service.findAllLoanApplications()));
    }
}
