package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.dto.GameCreateDTO;
import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.entity.Rule;
import com.allianztalents.unobackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class SessionController {

    public final GameService gameService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/{gameId}/playCard")
    public void playCard(@DestinationVariable Long gameId, @Payload Long cardId) throws Exception {
        messagingTemplate.convertAndSend("/topic/game/" + gameId,  gameService.playCard(gameId, cardId));
    }

    @MessageMapping("/{gameId}/drawCard")
    public void drawCard(@DestinationVariable Long gameId, @Payload int amount) throws Exception {
        messagingTemplate.convertAndSend("/topic/game/" + gameId,  gameService.drawCard(gameId, amount));
    }

    @MessageMapping("/startGame")
    public void createGame(){;
        Game game = gameService.createGame();
        messagingTemplate.convertAndSend("/topic/game/" , game);
    }
}
