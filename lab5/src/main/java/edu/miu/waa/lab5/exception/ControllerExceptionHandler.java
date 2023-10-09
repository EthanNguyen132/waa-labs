package edu.miu.waa.lab5.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {RecordNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse resourceNotFoundException(RecordNotFoundException ex, WebRequest request) {
        ErrorResponse message = ErrorResponse.create(
                ex, HttpStatus.NOT_FOUND, "Record Not Found!"
        );
        return message;
    }

    @ExceptionHandler(value = {InvalidRecordException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse resourceCannotBeSavedException(InvalidRecordException ex, WebRequest request) {
        ErrorResponse message = ErrorResponse.create(
                ex, HttpStatus.BAD_REQUEST, "Invalid data!"
        );
        return message;
    }
}
