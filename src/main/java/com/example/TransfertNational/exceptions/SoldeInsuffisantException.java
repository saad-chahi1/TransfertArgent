package com.example.TransfertNational.exceptions;

public class SoldeInsuffisantException extends RuntimeException {

    public SoldeInsuffisantException(String message) {
        super(message);
    }

    public SoldeInsuffisantException(Exception ex, String message) {
        super(message, ex);
    }
}
