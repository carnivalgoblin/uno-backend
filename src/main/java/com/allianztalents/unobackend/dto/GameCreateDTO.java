package com.allianztalents.unobackend.dto;

import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.entity.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameCreateDTO {
    @NotBlank
    List<Player> players;
    @NotBlank
    List<Rule>  rules;
}
