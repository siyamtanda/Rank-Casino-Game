package com.random.CasinoGame.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casino")
public class CasinoController {

    private final CasinoService casinoService;

    @Autowired
    public CasinoController(CasinoService casinoService) {
        this.casinoService = casinoService;
    }

    @GetMapping("/player/{playerId}/balance")
    public ResponseEntity<Double> getPlayerBalance(@PathVariable Long playerId) {
        double balance = casinoService.getPlayerBalance(playerId);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/player/{playerId}/balance/update")
    public ResponseEntity<Void> updatePlayerBalance(@PathVariable Long playerId,
                                                    @RequestBody BalanceUpdateRequest request) {
        try {
            casinoService.updatePlayerBalance(playerId, request.getAmount(), request.getTransactionType());
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/admin/player/transactions")
    public ResponseEntity<List<Transaction>> getLastTenTransactions(@RequestBody PlayerTransactionsRequest request) {
        List<Transaction> transactions = casinoService.getLastTenTransactions(request.getUsername());
        return ResponseEntity.ok(transactions);
    }
}
