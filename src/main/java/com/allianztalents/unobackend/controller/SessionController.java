package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.service.GameService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class SessionController {

    public GameService gameService;

    @MessageMapping("/playCard")
    @SendTo("/topic/game/{gameId}")
    public Game playCard(@DestinationVariable Long gameId, @Payload Map<String, Object> payload) throws Exception {
        Long cardId = (Long) payload.get("cardId");
        return gameService.playCard(gameId, cardId);
    }

    @MessageMapping("/drawCard")
    @SendTo("/topic/game/{gameId}")
    public Game drawCard(@DestinationVariable Long gameId, int amount) throws Exception {
        return gameService.drawCard(gameId, amount);
    }
}
