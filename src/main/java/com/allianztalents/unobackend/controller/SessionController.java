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
@RequiredArgsConstructor
public class SessionController {

    public final GameService gameService;

    private final SimpMessagingTemplate messagingTemplate;

    private final CardRepository cardRepository;

    // eig noch /app/gameId/playCard
    @MessageMapping("/{gameId}/playCard")
    public void playCard(@DestinationVariable Long gameId, @Payload Long cardId) throws Exception {
        messagingTemplate.convertAndSend("/topic/game/" + gameId,  gameService.playCard(gameId, cardId));
    }

    @MessageMapping("/{game}/drawCard")
    public void drawCard(@DestinationVariable Long gameId, @Payload int amount) throws Exception {
        messagingTemplate.convertAndSend("/topic/game/" + gameId,  gameService.drawCard(gameId, amount));
    }
}
