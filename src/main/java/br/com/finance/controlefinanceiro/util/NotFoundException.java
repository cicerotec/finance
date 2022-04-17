package br.com.finance.controlefinanceiro.util;

public class NotFoundException extends RuntimeException {
    private String message;
    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public NotFoundException() {
    }
}
