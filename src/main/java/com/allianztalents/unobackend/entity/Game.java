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

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  private Player winner;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  private List<Player> players = new ArrayList<>();

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  private Player currentPlayer = new Player();

  private Boolean reverse = true;


  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private CardDeck drawDeck;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private CardDeck deployDeck;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Turn> turns = new ArrayList<>();

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Rule> rules = new ArrayList<>();

  public Player getPlayerById(Long id) {
    for (Player player : players) {
      if (player.getId().equals(id)) {
        return player;
      }
    }
    return null;
  }
}
