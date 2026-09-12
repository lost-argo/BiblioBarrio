package org.bibliobarrio.exceptions;

public class OverdueLoanException extends Exception {
    public OverdueLoanException(String message) {
        super(message);
    }
}
