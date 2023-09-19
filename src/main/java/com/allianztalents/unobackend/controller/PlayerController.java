package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.repository.PlayerRepository;
import com.allianztalents.unobackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// ZU Websocket ändern, damit die player in realtime hinzugefügt werden können und auch abgerufen werden können

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

  private final GameService gameService;
  private final PlayerRepository playerRepository;

  @PostMapping
  public Player addPlayer(@RequestBody Player player){

    return playerRepository.save(player);
  }

  // ADDING PLAYERS TO GAME BEFORE STARTING GAME NOT WORKING ANYMORE

//  @PostMapping("/{gameId}/addPlayers")
//  public Game addPlayers(@PathVariable("gameId") long gameId){
//    List<Player> players = gameService.getPlayers();
//    return gameService.addPlayers(gameId, players);
//  }

  @GetMapping
  public List<Player> getPlayers(){

    return playerRepository.findAll();
  }

}
