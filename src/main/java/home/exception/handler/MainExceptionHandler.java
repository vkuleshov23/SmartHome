package home.exception.handler;

import home.exception.InvalidIDException;
import home.exception.InvalidIncomingData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InvalidIDException.class)
    protected ResponseEntity<?> handle(InvalidIDException e, WebRequest request) {
        return createResponse(e, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = InvalidIncomingData.class)
    protected ResponseEntity<?> handle(InvalidIncomingData e, WebRequest request) {
        return createResponse(e, HttpStatus.BAD_REQUEST, request);
    }

    private ResponseEntity<?> createResponse(Exception e, HttpStatus status, WebRequest request) {
        return this.handleExceptionInternal(
                e,
                e.getMessage(),
                new HttpHeaders(),
                status,
                request);
    }

}
