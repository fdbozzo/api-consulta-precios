package io.swagger.controller;


import io.swagger.api.ApiResponseMessage;
import io.swagger.exceptions.ApiException;
import io.swagger.exceptions.NotFoundException;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class GlobalExceptionRestController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiResponseMessage response = new ApiResponseMessage(status.toString(), ex.getBindingResult().toString());
        return new ResponseEntity(response, status);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiResponseMessage response = new ApiResponseMessage(status.toString(), ex.getMessage());
        return new ResponseEntity(response, status);
    }

    @ExceptionHandler({IOException.class})
    public ResponseEntity<ApiException> ioExceptionHandler(IOException ioException) {
//        return new ResponseEntity<>(ioException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity(
            new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), ioException.getMessage()) ,
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiException> notFoundExceptionHandler(ApiException exception) {
        return new ResponseEntity(
            new ApiException(HttpStatus.NOT_FOUND.value(), exception.getMessage()) ,
            HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiException> apiExceptionHandler(ApiException exception) {
        return new ResponseEntity(
            new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage()) ,
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiException> exceptionHandler(Exception exception) {
        return new ResponseEntity(
            new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage()) ,
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
