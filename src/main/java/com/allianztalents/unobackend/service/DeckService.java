package com.allianztalents.unobackend.service;

import com.allianztalents.unobackend.entity.Card;
import com.allianztalents.unobackend.entity.CardDeck;
import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeckService {

    @Autowired
    private CardRepository cardRepository;

    public CardDeck initializeDeck() {
        //Liste mit doppeltem Kartensatz erstellen und mischen

        CardDeck deck = new CardDeck();

        List<Card> cards = new ArrayList<>(cardRepository.findAll());

        deck.setCards(cards);

        //Mischen
        deck = shuffleDeck(deck);

        return deck;
    }

    public CardDeck shuffleDeck(CardDeck deck) {
        //Mischen
        Collections.shuffle(deck.getCards());

        return deck;
    }

    // nun bekommen die spieler ihre karten
    public List<Card> dealCards(CardDeck deck, int numberOfCards) {
        //Karten austeilen
        List<Card> hand = new ArrayList<>(deck.getCards().subList(0, numberOfCards));

        deck.getCards().removeAll(hand);

        return hand;
    }

    public void placeCardOnDeckAndRemoveOnPlayer(CardDeck deck, Card card, Player player) {
        //Karte auf den Ablagestapel legen und aus der Hand löschen
        deck.getCards().add(card);
        player.getCards().remove(card);
    }

    public List<Card> getAllCards() {

        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        
        return cardRepository.findById(id).orElse(null);
    }

}
