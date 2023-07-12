package com.random.CasinoGame.model;
import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    private double amount;

    @Column(name = "transaction_type")
    private String transactionType; // WAGER or WIN

    // Other transaction attributes, such as timestamp, game ID, etc.

    // Constructors, getters, and setters
}
