package org.example.exception;

public class SocksNotEnoughException extends RuntimeException {
    public SocksNotEnoughException(String message) {
        super((message));
    }
}
