package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.entity.Card;
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
  public Game startGame(@RequestBody Game _game){
    return gameService.insert(_game);
  }

  @GetMapping
  public List<Game> getGame(){
    return gameService.getGame();
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
