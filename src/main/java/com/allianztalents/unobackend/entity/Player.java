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
  private Long playerId;

  private String name;

  @OneToMany(fetch = FetchType.EAGER)
  private List<Card> cards;

  private Integer points;

}
