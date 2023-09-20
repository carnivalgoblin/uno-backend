package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {

  private final GameService gameService;
  private final SimpMessagingTemplate messagingTemplate;

  @MessageMapping("/addPlayer")
  public void addPlayer(@Payload String playerName){

    gameService.addPlayer(playerName);

    messagingTemplate.convertAndSend("/topic/lobby",  gameService.getPlayers());
  }

  @MessageMapping("/getPlayers")
  public void getAllPlayers() {

    messagingTemplate.convertAndSend("/topic/lobby",  gameService.getPlayers());
  }

}
