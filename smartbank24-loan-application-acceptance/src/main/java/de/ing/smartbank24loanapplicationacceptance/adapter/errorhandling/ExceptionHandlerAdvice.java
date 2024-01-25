package de.ing.smartbank24loanapplicationacceptance.adapter.errorhandling;


import de.ing.smartbank24loanapplicationacceptance.domain.service.LoanApplicationServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice

public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	public static final String TIMESTAMP = "timestamp";
	public static final String MESSAGE = "message";

	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(MESSAGE, ex.getMessage());

		logger.error("Unexpected Error",ex);
        return ResponseEntity.internalServerError().body(body);
    }
	
	@ExceptionHandler(LoanApplicationServiceException.class)
	public ResponseEntity<Object> handleKreditantragServiceException(LoanApplicationServiceException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(MESSAGE, ex.getMessage());
        logger.error("Fehler beim Verarbeiten des Kreditantrags", ex);// Wichtig
        return ResponseEntity.badRequest().body(body);
    }

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatusCode status, final WebRequest request) {
		Map<String, Object> body = new HashMap<>();


		body.put(TIMESTAMP, LocalDateTime.now());
		body.put("status", status.value());


		List<String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(x -> x.getField() + " -> " + x.getDefaultMessage() )
				.collect(Collectors.toList());

		body.put(MESSAGE, errors);
		logger.warn("Fehler beim Validieren",ex);
		return ResponseEntity.badRequest().body(body);
	}



}
