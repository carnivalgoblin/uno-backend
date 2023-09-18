package com.allianztalents.unobackend.service;

import com.allianztalents.unobackend.entity.Card;
import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.entity.Turn;
import com.allianztalents.unobackend.entity.enumeration.Color;
import com.allianztalents.unobackend.entity.enumeration.Numeration;
import com.allianztalents.unobackend.entity.enumeration.SpecialEffect;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ValidationService {

    public Turn validateTurn(Game game, Card card) throws Exception {

        Turn turn = new Turn();

        turn.setCard(card);

        Card lastValidCard = validateLastCard(game);

        turn.setCard(validateCard(card, lastValidCard));

        turn.setPlayer(game.getCurrentPlayer());

        turn.setIsDrawn(false);

        return turn;
    }

    public Turn validateDrawTurn(Game game) throws Exception {

        Turn turn = new Turn();

        turn.setCard(null);

        turn.setPlayer(game.getCurrentPlayer());

        turn.setIsDrawn(true);

        return turn;
    }

    public Card validateLastCard(Game game) throws Exception {
        Optional<Turn> lastNotDrawnTurn = game.getTurns().stream()
            .filter(turn -> !turn.getIsDrawn())
            .reduce((first, second) -> second);

        Turn turn;

        if (lastNotDrawnTurn.isPresent()) {
            System.out.println("Turn found");
            turn = lastNotDrawnTurn.get();
        } else {
            System.out.println("Fehlerhafter Spielzug.");
            throw new Exception("Fehlerhafter Spielzug.");
        }

        return turn.getCard();
    }

    public Card validateCard(Card card, Card lastValidCard) throws Exception {

        if (card.getColor().equals(lastValidCard.getColor()) || card.getNumeration().equals(lastValidCard.getNumeration())) {
            return card;
        } else if (card.getSpecialEffect().equals(SpecialEffect.COLOR_WISH) || card.getSpecialEffect().equals(SpecialEffect.DRAW_FOUR_COLOR_WISH)) {
            return card;
        } else {
            System.out.println("Fehlerhafter Spielzug.");
            throw new Exception("Fehlerhafter Spielzug.");
        }
    }


}
