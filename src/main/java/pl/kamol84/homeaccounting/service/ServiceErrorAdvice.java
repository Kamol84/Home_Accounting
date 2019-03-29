package pl.kamol84.homeaccounting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.kamol84.homeaccounting.model.ErrorMesage;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.time.LocalDateTime;

@ControllerAdvice
public class ServiceErrorAdvice {

    @Autowired
    ErrorMesage errorMesage;

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity handle(DataIntegrityViolationException e) {
        errorMesage.setTimestamp(LocalDateTime.now());
        errorMesage.setStatus("400");
        errorMesage.setError(HttpStatus.BAD_REQUEST.name());
        errorMesage.setMessage( "Dane nie mogą się powtarzać");
//        errorMesage.setPath();

        return new ResponseEntity(errorMesage, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity handle(EntityNotFoundException e) {
        errorMesage.setTimestamp(LocalDateTime.now());
        errorMesage.setStatus("404");
        errorMesage.setError(HttpStatus.NOT_FOUND.name());
        errorMesage.setMessage("wybrana grupa nie istnieje");
//        errorMesage.setPath();
        return new ResponseEntity(errorMesage, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalStateException.class})
    public ResponseEntity handle(IllegalStateException e) {
        errorMesage.setTimestamp(LocalDateTime.now());
        errorMesage.setStatus("400");
        errorMesage.setError(HttpStatus.BAD_REQUEST.name());
        errorMesage.setMessage("niekompletne dane");
        //        errorMesage.setPath();
        return new ResponseEntity(errorMesage, null, HttpStatus.BAD_REQUEST);
    }

}