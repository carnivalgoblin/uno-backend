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

    /**
     * Die Funktion validiert, ob die Karte gespielt werden darf. Aufgrund der Farbe oder der Nummer.
     * @param game Game, in dem gespielt wird
     * @param card Karte, die gespielt werden soll
     * @return Turn, indem die Karte gesetzt ist und isDrawn false ist
     * @throws Exception Es wurde keine letzte Karte gefunden oder die Karte ist nicht spielbar
     */
    public Turn validateTurn(Game game, Card card) throws Exception {

        Turn turn = new Turn();

        turn.setCard(card);

        Card lastValidCard = validateLastCard(game);

        turn.setCard(validateCard(card, lastValidCard));

        turn.setPlayer(game.getCurrentPlayer());

        turn.setIsDrawn(false);

        return turn;
    }

    /**
     * Die Funktion validiert den Spielzug und gibt einen Turn zurück.
     * @param game Game, in dem gespielt wird
     * @return Turn, indem die Karte null ist und isDrawn true ist
     */
    public Turn validateDrawTurn(Game game) {

        Turn turn = new Turn();

        turn.setCard(null);

        turn.setPlayer(game.getCurrentPlayer());

        turn.setIsDrawn(true);

        return turn;
    }

    /**
     * Die Funktion validiert, ob es eine letzte gültige Karte gibt.
     * @param game Game, in dem gespielt wird
     * @return Card, die zuletzt gespielt wurde
     * @throws Exception Es wurde keine letzte Karte gefunden
     */
    public Card validateLastCard(Game game) throws Exception {
        Optional<Turn> lastNotDrawnTurn = game.getTurns().stream()
            .filter(turn -> !turn.getIsDrawn())
            .reduce((first, second) -> second);

        Turn turn;

        if (lastNotDrawnTurn.isPresent()) {
            System.out.println("Turn found");
            turn = lastNotDrawnTurn.get();
        } else {
            throw new Exception("No last Card found");
        }

        return turn.getCard();
    }

    /**
     * Die Funktion validiert, ob die Karte einen gültigen Spielzug darstellt. Indem sie die Farbe oder die Nummer der Karte mit der letzten gültigen Karte vergleicht.
     * @param card Karte, die gespielt werden soll
     * @param lastValidCard Card, die zuletzt gespielt wurde
     * @return Card, die Validiert wurde und gespielt werden darf
     * @throws Exception Karte nicht spielbar
     */
    public Card validateCard(Card card, Card lastValidCard) throws Exception {
//TODO WENN ES EIN AUSSETZEN IST DARF NICHT GEZOGEN WERDEN
        if (card.getColor().equals(lastValidCard.getColor()) || card.getNumeration().equals(lastValidCard.getNumeration())) {
            System.out.println("Card possible to play");
            return card;
        } else if (card.getSpecialEffect().equals(SpecialEffect.COLOR_WISH) || card.getSpecialEffect().equals(SpecialEffect.DRAW_FOUR_COLOR_WISH)) {
            System.out.println("Card possible to play");
            return card;
        } else {
            throw new Exception("Card is not possible to play");
        }
    }


}
