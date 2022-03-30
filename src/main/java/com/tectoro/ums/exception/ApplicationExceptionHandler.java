package com.tectoro.ums.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> hadleResourceNotFoundException(ResourceNotFoundException e,
                                                            WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),
                webRequest.getDescription(false));

        return new ResponseEntity(errorDetails,
                HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(ResourceNotFoundException e,
                                                   WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);


    }

}
