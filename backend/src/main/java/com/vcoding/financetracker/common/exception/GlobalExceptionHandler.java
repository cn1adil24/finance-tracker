package com.vcoding.financetracker.common.exception;

import com.vcoding.financetracker.common.dto.ErrorResponse;
import com.vcoding.financetracker.transaction.exception.TransactionNotFoundException;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(TransactionNotFoundException.class)
  public ResponseEntity<String> handleTransactionNotFoundException(
      TransactionNotFoundException ex) {

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {

    Map<String, String> errors =
        ex.getBindingResult().getFieldErrors().stream()
            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

    ErrorResponse response = new ErrorResponse("Validation failed", errors);

    return ResponseEntity.badRequest().body(response);
  }
}
