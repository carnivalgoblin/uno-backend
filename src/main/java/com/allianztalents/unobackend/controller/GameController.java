package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uno")
@RequiredArgsConstructor
public class GameController {
  private final GameService gameService;

  @PostMapping
  public Game startGame(@RequestBody Game _game){
    return gameService.insert(_game);
  }

  @GetMapping
  public List<Game> getGame(){
    return gameService.getGame();
  }

}
