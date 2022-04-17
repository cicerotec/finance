package br.com.finance.controlefinanceiro.web;

import br.com.finance.controlefinanceiro.util.NotFoundException;
import com.couchbase.client.core.error.DocumentNotFoundException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static String NOT_FOUND = "O id informado não foi encontrado!";
    private final static String INTERNAL_SERVER_ERROR = "Erro interno do servidor!";

    @ExceptionHandler(value = {
            NotFoundException.class,
            DataRetrievalFailureException.class,
            DocumentNotFoundException.class})
    public ResponseEntity notFoundException() {
        return new ResponseEntity(NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception exception) {
        return new ResponseEntity(INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
