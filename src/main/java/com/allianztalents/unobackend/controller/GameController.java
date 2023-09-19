package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.dto.GameCreateDTO;
import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.entity.Card;
import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.entity.Rule;
import com.allianztalents.unobackend.service.DeckService;
import com.allianztalents.unobackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/uno")
@RequiredArgsConstructor
public class GameController {
  private final GameService gameService;
  private final DeckService deckService;

  @PostMapping
  public Game createGame(@RequestBody GameCreateDTO gameCreateDTO){
//    List<Player> players = gameCreateDTO.getPlayers();
    List<Rule> rules = gameCreateDTO.getRules();

    return gameService.createGame(rules);
  }

  @GetMapping
  public List<Game> getGames(){
    return gameService.getGames();
  }

  @GetMapping("/cards")
  public List<Card> getAllCards(){
    return deckService.getAllCards();
  }

  @GetMapping("/cards/{cardId}")
  //TODO Check @Valid und später hinzufügen
  public Card getCardById(@PathVariable("cardId") long id){
    return deckService.getCardById(id);
  }

}
