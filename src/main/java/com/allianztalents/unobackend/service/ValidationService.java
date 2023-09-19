package com.allianztalents.unobackend.service;

import com.allianztalents.unobackend.entity.Card;
import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.entity.Turn;
import com.allianztalents.unobackend.entity.enumeration.SpecialEffect;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

        Card lastValidCard = validateLastPlayedCard(game);

        turn.setCard(validateCardAgainstCard(card, lastValidCard));

        turn.setPlayer(game.getCurrentPlayer());

        turn.setIsDrawn(false);
        turn.setIsSkipped(false);

        return turn;
    }

    /**
     * Die Funktion validiert den Spielzug und gibt einen Turn zurück.
     * @param game Game, in dem gespielt wird
     * @return Turn, indem die Karte null ist und isDrawn true ist
     */
    public Turn createDrawTurn(Game game, List<Card> cards) {

        Turn turn = new Turn();

        turn.setCards(cards);

        turn.setPlayer(game.getCurrentPlayer());

        turn.setIsDrawn(true);
        turn.setIsSkipped(false);

        return turn;
    }

    /**
     * Die Funktion validiert, ob es eine letzte gültige Karte gibt.
     * @param game Game, in dem gespielt wird
     * @return Card, die zuletzt gespielt wurde
     */
    public static Card validateLastPlayedCard(Game game) {
        Optional<Turn> lastNotDrawnTurn = game.getTurns().stream()
            .filter(turn -> !turn.getIsDrawn())
            .filter(turn -> !turn.getIsSkipped())
            .reduce((first, second) -> second);

        Turn turn;

        if (lastNotDrawnTurn.isPresent()) {
            System.out.println("Turn found");
            turn = lastNotDrawnTurn.get();
        } else {
            System.out.println("Used first Deck Card to Validate");
            return game.getDeployDeck().getCards().get(game.getDeployDeck().getCards().size() -1);
        }

        return turn.getFirstCard();
    }

    /**
     * Die Funktion validiert, ob die Karte einen gültigen Spielzug darstellt. Indem sie die Farbe oder die Nummer der Karte mit der letzten gültigen Karte vergleicht.
     * @param card Karte, die gespielt werden soll
     * @param lastValidCard Card, die zuletzt gespielt wurde
     * @return Card, die Validiert wurde und gespielt werden darf
     * @throws Exception Karte nicht spielbar
     */
    public Card validateCardAgainstCard(Card card, Card lastValidCard) throws Exception {
        if (card.getColor().equals(lastValidCard.getColor()) || card.getNumeration().equals(lastValidCard.getNumeration()) || card.getSpecialEffect().equals(lastValidCard.getSpecialEffect())) {
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
