package com.random.CasinoGame.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasinoService {

    private final PlayerRepository playerRepository;
    private final TransactionRepository transactionRepository;
    private final BalanceRepository balanceRepository;

    @Autowired
    public CasinoService(PlayerRepository playerRepository,
                         TransactionRepository transactionRepository,
                         BalanceRepository balanceRepository) {
        this.playerRepository = playerRepository;
        this.transactionRepository = transactionRepository;
        this.balanceRepository = balanceRepository;
    }

    public double getPlayerBalance(Long playerId) {
        Player player = getPlayer(playerId);
        return balanceRepository.findByPlayer(player)
                .map(Balance::getBalanceAmount)
                .orElse(0.0);
    }

    public void updatePlayerBalance(Long playerId, double amount, String transactionType) {
        Player player = getPlayer(playerId);
        Balance balance = balanceRepository.findByPlayer(player)
                .orElseThrow(() -> new RuntimeException("Balance not found for player: " + player.getUsername()));

        if (transactionType.equals("WAGER")) {
            if (amount > balance.getBalanceAmount()) {
                throw new IllegalArgumentException("Wager amount exceeds the player's balance");
            }
            balance.setBalanceAmount(balance.getBalanceAmount() - amount);
        } else if (transactionType.equals("WIN")) {
            balance.setBalanceAmount(balance.getBalanceAmount() + amount);
        } else {
            throw new IllegalArgumentException("Invalid transaction type");
        }

        balanceRepository.save(balance);
    }

    public List<Transaction> getLastTenTransactions(Long playerId) {
        Player player = getPlayer(playerId);
        return transactionRepository.findTop10ByPlayerOrderByTimestampDesc(player);
    }

    private Player getPlayer(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid player ID: " + playerId));
    }
}
