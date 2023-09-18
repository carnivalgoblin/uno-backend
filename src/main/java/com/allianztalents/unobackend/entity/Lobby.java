package com.allianztalents.unobackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Lobby {

  // ATTRIBUTES

  @Id
  private Long lobbyId;

  // METHODS

}
