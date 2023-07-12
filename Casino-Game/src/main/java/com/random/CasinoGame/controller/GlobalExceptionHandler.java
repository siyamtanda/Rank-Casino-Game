package com.random.CasinoGame.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.casino.exception.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidPlayerIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleInvalidPlayerIdException(InvalidPlayerIdException ex) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(NegativeAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleNegativeAmountException(NegativeAmountException ex) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(WagerGreaterThanBalanceException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @ResponseBody
    public ErrorResponse handleWagerGreaterThanBalanceException(WagerGreaterThanBalanceException ex) {
        return new ErrorResponse(HttpStatus.I_AM_A_TEAPOT.value(), ex.getMessage());
    }
}
