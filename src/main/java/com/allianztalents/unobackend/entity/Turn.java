package com.allianztalents.unobackend.entity;

import jakarta.persistence.*;

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Player player = new Player();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Card card = new Card();
}