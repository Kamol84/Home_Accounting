package pl.kamol84.homeaccounting.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class UserServiceErrorAdvice {

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity handle(DataIntegrityViolationException e) {
        return new ResponseEntity("Dane nie mogą się powtarzać", null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity handle(EntityNotFoundException e) {
        return new ResponseEntity("wybrana grupa nie istnieje", null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IllegalStateException.class})
    public ResponseEntity handle(IllegalStateException e) {
        return new ResponseEntity("niekompletne dane", null, HttpStatus.BAD_REQUEST);
    }

}