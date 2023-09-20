package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {

  private final GameService gameService;

  @MessageMapping("/addPlayer")
  public int addPlayer(@Payload Player player){

    gameService.addPlayer(player);

    return gameService.getNumberOfPlayers();
  }

  @MessageMapping("/getPlayers")
  public List<Player> getAllPlayers() {
    List<Player> players = gameService.getPlayers();

    return players;
  }

}
