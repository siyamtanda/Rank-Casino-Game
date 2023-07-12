package com.random.CasinoGame.exception;

public class WagerGreaterThanBalanceException extends RuntimeException {
    public WagerGreaterThanBalanceException(String message) {
        super(message);
    }
}
