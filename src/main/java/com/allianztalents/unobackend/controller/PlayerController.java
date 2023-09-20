package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.repository.PlayerRepository;
import com.allianztalents.unobackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// ZU Websocket ändern, damit die player in realtime hinzugefügt werden können und auch abgerufen werden können

@Controller
@RequiredArgsConstructor
public class PlayerController {

  private final GameService gameService;
  private final PlayerRepository playerRepository;

  @MessageMapping("/addPlayer")
  public int addPlayer(@Payload Player player){

    gameService.addPlayer(player);

    return gameService.getNumberOfPlayers();
  }

  // ADDING PLAYERS TO GAME BEFORE STARTING GAME NOT WORKING ANYMORE

//  @PostMapping("/{gameId}/addPlayers")
//  public Game addPlayers(@PathVariable("gameId") long gameId){
//    List<Player> players = gameService.getPlayers();
//    return gameService.addPlayers(gameId, players);
//  }

  @MessageMapping("/getPlayers")
  public List<Player> getAllPlayers() {
    List<Player> players = gameService.getPlayers();

    return players;
  }

}
