package com.random.CasinoGame.model;

import javax.persistence.*;


@Entity
@Table(name = "balances")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "balance_amount")
    private double balanceAmount;

    // Constructors, getters, and setters
}
