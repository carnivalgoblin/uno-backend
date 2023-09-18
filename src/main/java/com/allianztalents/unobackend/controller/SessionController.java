package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.entity.Game;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SessionController {

    @MessageMapping("/playCard")
    @SendTo("/topic/game/{gameId}")
    public Game playCard(@DestinationVariable Long gameId) {

        return null; //temporary
    }

    @MessageMapping("/drawCard")
    @SendTo("/topic/game/{gameId}")
    public Game drawCard(@DestinationVariable Long gameId) {

        return null; //temporary
    }
}
