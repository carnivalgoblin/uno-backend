package com.allianztalents.unobackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Player {

  // ATTRIBUTES

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  private List<Card> cards;

  private Integer points;

  public Player(String name) {
    this.name = name;
    this.points = 0;
  }

}
