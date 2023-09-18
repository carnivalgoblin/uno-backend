package com.allianztalents.unobackend.service;

import com.allianztalents.unobackend.entity.Card;
import com.allianztalents.unobackend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> initializeDeck() {
        //Liste mit doppeltem Kartensatz erstellen und mischen

        List<Card> deck = cardRepository.findAll();
        deck.addAll(cardRepository.findAll());

        //Mischen

        deck = shuffleDeck(deck);

        return deck;
    }

    public List<Card> shuffleDeck(List<Card> deck) {
        //Mischen
        deck.sort((o1, o2) -> {
            if (Math.random() < 0.5) {
                return -1;
            } else {
                return 1;
            }
        });

        return deck;
    }

    // nun bekommen die spieler ihre karten
    public List<Card> dealCards(List<Card> deck, int numberOfCards) {
        //Karten austeilen
        List<Card> hand = deck.subList(0, numberOfCards);
        deck.removeAll(hand);

        return hand;
    }

    public List<Card> getAllCards() {

        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        
        return cardRepository.findById(id).orElse(null);
    }

}
