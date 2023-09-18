package com.allianztalents.unobackend.entity;

import com.allianztalents.unobackend.entity.enumeration.RuleName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Rule {

  //ATTRIBUTES

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ruleId;

  private RuleName ruleName;

  private String ruleDescription;

  private Integer ruleValue;

  private Boolean ruleActive;

  // METHODS
}
