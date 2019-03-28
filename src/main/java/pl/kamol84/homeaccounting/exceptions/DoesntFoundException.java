package pl.kamol84.homeaccounting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DoesntFoundException extends RuntimeException {
    public DoesntFoundException(String message) {
        super(message);
    }
}
