package com.allianztalents.unobackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Game {

  //ATTRIBUTES

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String gameName;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Player winner = new Player();

  @OneToMany(fetch = FetchType.EAGER)
  private List<Player> players;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Player currentPlayer = new Player();

  private Boolean clockwiseRotation = true;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private CardDeck drawDeck = new CardDeck();

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private CardDeck deployDeck = new CardDeck();

  @OneToMany(fetch = FetchType.EAGER)
  private List<Turn> turns = new ArrayList<>();

  @OneToMany(fetch = FetchType.EAGER)
  private List<Rule> rules = new ArrayList<>();


  // METHODS

}
