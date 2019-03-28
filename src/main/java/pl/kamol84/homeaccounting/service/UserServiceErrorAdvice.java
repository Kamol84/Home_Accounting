package pl.kamol84.homeaccounting.service;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class UserServiceErrorAdvice {

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity handle(DataIntegrityViolationException e) {
        return new ResponseEntity("Użytkownik o takim loginie lub eMailu już istnieje", null, HttpStatus.I_AM_A_TEAPOT);
    }
}