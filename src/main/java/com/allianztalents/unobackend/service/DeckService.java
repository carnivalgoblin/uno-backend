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
        return null;
    }

    public List<Card> getAllCards() {

        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        
        return cardRepository.findById(id).orElse(null);
    }

}
