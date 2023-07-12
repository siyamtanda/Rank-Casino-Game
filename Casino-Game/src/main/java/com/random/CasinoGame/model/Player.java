package com.random.CasinoGame.model;
import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    // Other player attributes, such as name, email, etc.

    // Constructors, getters, and setters
}
