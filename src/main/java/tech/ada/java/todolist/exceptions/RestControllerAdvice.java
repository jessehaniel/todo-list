package tech.ada.java.todolist.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

    public static final String METHOD_ARGUMENT_NOT_VALID_ERROR_MESSAGE = "Campo inválido: '%s'. Causa: '%s'.";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error(ex.getMessage(), ex);
        String errorMessage = getErrorMessages(ex.getBindingResult());
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final ErrorResponse errorResponse = new ErrorResponse(ex.getClass(), httpStatus, errorMessage);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    //@formatter:off
    private String getErrorMessages(BindingResult bindingResult) {
        return Stream.concat(
            bindingResult.getFieldErrors().stream().map(this::getMethodArgumentNotValidErrorMessage),
            bindingResult.getGlobalErrors().stream().map(this::getMethodArgumentNotValidErrorMessage)
        ).collect(Collectors.joining(", "));
    }
    //@formatter:on

    private String getMethodArgumentNotValidErrorMessage(FieldError error) {
        return String.format(METHOD_ARGUMENT_NOT_VALID_ERROR_MESSAGE, error.getField(), error.getDefaultMessage());
    }

    private String getMethodArgumentNotValidErrorMessage(ObjectError error) {
        return String.format(METHOD_ARGUMENT_NOT_VALID_ERROR_MESSAGE, error.getObjectName(), error.getDefaultMessage());
    }

    @ExceptionHandler(value = NaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> recursoNaoEncontradoExceptionHandler(NaoEncontradoException ex) {
        final ErrorResponse errorResponse = new ErrorResponse(ex.getClass(), ex.getStatus(), ex.getMessage());
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> constraintViolationException(ConstraintViolationException ex) {
        final String message = ex.getConstraintViolations().stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.joining(", "));
        final ErrorResponse errorResponse = new ErrorResponse(ex.getClass(), HttpStatus.BAD_REQUEST, message);
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> defaultExceptionHandler(Exception ex) {
        final ErrorResponse errorResponse =
            new ErrorResponse(ex.getClass(), HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
