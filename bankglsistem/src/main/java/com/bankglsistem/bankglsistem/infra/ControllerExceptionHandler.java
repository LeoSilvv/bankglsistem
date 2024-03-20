package com.bankglsistem.bankglsistem.infra;

import com.bankglsistem.bankglsistem.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicationEntry(DataIntegrityViolationException exception){
        ExceptionDTO newExceptionDTO = new ExceptionDTO("Usuario já cadastrado", "400");
        return ResponseEntity.badRequest().body(newExceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity threatGeneralException(Exception exception){
        ExceptionDTO newExceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(newExceptionDTO);
    }
}
