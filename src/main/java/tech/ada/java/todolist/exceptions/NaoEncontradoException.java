package tech.ada.java.todolist.exceptions;

import org.springframework.http.HttpStatus;

public class NaoEncontradoException extends AbstractException {

    public NaoEncontradoException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
