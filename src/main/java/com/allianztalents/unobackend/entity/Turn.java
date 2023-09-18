package com.allianztalents.unobackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Player player = new Player();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Card> cards = new ArrayList<>();

    private Boolean isDrawn;
    private Boolean isSkipped;

    public Card getFirstCard () {
        return cards.get(0);
    }

    public void setCard (Card card) {
        cards.add(card);
    }
}
