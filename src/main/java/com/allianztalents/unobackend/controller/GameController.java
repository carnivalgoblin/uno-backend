package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class GameController {

  public final GameService gameService;
  private final SimpMessagingTemplate messagingTemplate;

  @MessageMapping("/{gameId}/playCard")
  public void playCard(@DestinationVariable Long gameId, @Payload Long cardId) throws Exception {
    messagingTemplate.convertAndSend("/topic/game/" + gameId,  gameService.playCard(gameId, cardId));
  }

  @MessageMapping("/{gameId}/drawCard")
  public void drawCard(@DestinationVariable Long gameId, @Payload int amount) {
    messagingTemplate.convertAndSend("/topic/game/" + gameId,  gameService.drawCard(gameId, amount));
  }

  @MessageMapping("/startGame")
  public void createGame(){
    Game game = gameService.createGame();

    Game gamesend = gameService.getGameById(game.getId());
    messagingTemplate.convertAndSend("/topic/game" , gamesend);
  }

  @MessageMapping("/getGame/{gameId}")
  public void getGame(@DestinationVariable Long gameId){
    Game game = gameService.getGameById(gameId);
    messagingTemplate.convertAndSend("/topic/game/"  + gameId, game);
  }
}
