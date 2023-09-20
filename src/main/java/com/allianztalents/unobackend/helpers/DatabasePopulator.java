package com.allianztalents.unobackend.helpers;

import com.allianztalents.unobackend.entity.Card;
import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.entity.enumeration.Color;
import com.allianztalents.unobackend.entity.enumeration.Numeration;
import com.allianztalents.unobackend.entity.enumeration.SpecialEffect;
import com.allianztalents.unobackend.repository.CardRepository;
import com.allianztalents.unobackend.repository.GameRepository;
import com.allianztalents.unobackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulator implements CommandLineRunner {

    private CardRepository cardRepository;
    private GameRepository gameRepository;
    private PlayerRepository playerRepository;

    @Autowired
    public DatabasePopulator(CardRepository cardRepository, GameRepository gameRepository, PlayerRepository playerRepository) {
        this.cardRepository = cardRepository;
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        // RED CARDS
        cardRepository.save(new Card(Color.RED, Numeration.ZERO));
        cardRepository.save(new Card(Color.RED, Numeration.ONE));
        cardRepository.save(new Card(Color.RED, Numeration.TWO));
        cardRepository.save(new Card(Color.RED, Numeration.THREE));
        cardRepository.save(new Card(Color.RED, Numeration.FOUR));
        cardRepository.save(new Card(Color.RED, Numeration.FIVE));
        cardRepository.save(new Card(Color.RED, Numeration.SIX));
        cardRepository.save(new Card(Color.RED, Numeration.SEVEN));
        cardRepository.save(new Card(Color.RED, Numeration.EIGHT));
        cardRepository.save(new Card(Color.RED, Numeration.NINE));
        cardRepository.save(new Card(Color.RED, SpecialEffect.SKIP));
        cardRepository.save(new Card(Color.RED, SpecialEffect.REVERSE));
        cardRepository.save(new Card(Color.RED, SpecialEffect.DRAW_TWO));


        // BLUE CARDS
        cardRepository.save(new Card(Color.BLUE, Numeration.ZERO));
        cardRepository.save(new Card(Color.BLUE, Numeration.ONE));
        cardRepository.save(new Card(Color.BLUE, Numeration.TWO));
        cardRepository.save(new Card(Color.BLUE, Numeration.THREE));
        cardRepository.save(new Card(Color.BLUE, Numeration.FOUR));
        cardRepository.save(new Card(Color.BLUE, Numeration.FIVE));
        cardRepository.save(new Card(Color.BLUE, Numeration.SIX));
        cardRepository.save(new Card(Color.BLUE, Numeration.SEVEN));
        cardRepository.save(new Card(Color.BLUE, Numeration.EIGHT));
        cardRepository.save(new Card(Color.BLUE, Numeration.NINE));
        cardRepository.save(new Card(Color.BLUE, SpecialEffect.SKIP));
        cardRepository.save(new Card(Color.BLUE, SpecialEffect.REVERSE));
        cardRepository.save(new Card(Color.BLUE, SpecialEffect.DRAW_TWO));


        // GREEN CARDS
        cardRepository.save(new Card(Color.GREEN, Numeration.ZERO));
        cardRepository.save(new Card(Color.GREEN, Numeration.ONE));
        cardRepository.save(new Card(Color.GREEN, Numeration.TWO));
        cardRepository.save(new Card(Color.GREEN, Numeration.THREE));
        cardRepository.save(new Card(Color.GREEN, Numeration.FOUR));
        cardRepository.save(new Card(Color.GREEN, Numeration.FIVE));
        cardRepository.save(new Card(Color.GREEN, Numeration.SIX));
        cardRepository.save(new Card(Color.GREEN, Numeration.SEVEN));
        cardRepository.save(new Card(Color.GREEN, Numeration.EIGHT));
        cardRepository.save(new Card(Color.GREEN, Numeration.NINE));
        cardRepository.save(new Card(Color.GREEN, SpecialEffect.SKIP));
        cardRepository.save(new Card(Color.GREEN, SpecialEffect.REVERSE));
        cardRepository.save(new Card(Color.GREEN, SpecialEffect.DRAW_TWO));

        // YELLOW CARDS
        cardRepository.save(new Card(Color.YELLOW, Numeration.ZERO));
        cardRepository.save(new Card(Color.YELLOW, Numeration.ONE));
        cardRepository.save(new Card(Color.YELLOW, Numeration.TWO));
        cardRepository.save(new Card(Color.YELLOW, Numeration.THREE));
        cardRepository.save(new Card(Color.YELLOW, Numeration.FOUR));
        cardRepository.save(new Card(Color.YELLOW, Numeration.FIVE));
        cardRepository.save(new Card(Color.YELLOW, Numeration.SIX));
        cardRepository.save(new Card(Color.YELLOW, Numeration.SEVEN));
        cardRepository.save(new Card(Color.YELLOW, Numeration.EIGHT));
        cardRepository.save(new Card(Color.YELLOW, Numeration.NINE));
        cardRepository.save(new Card(Color.YELLOW, SpecialEffect.SKIP));
        cardRepository.save(new Card(Color.YELLOW, SpecialEffect.REVERSE));
        cardRepository.save(new Card(Color.YELLOW, SpecialEffect.DRAW_TWO));

        // SPECIAL CARDS
        cardRepository.save(new Card(Color.BLACK, SpecialEffect.DRAW_FOUR_COLOR_WISH));
        cardRepository.save(new Card(Color.BLACK, SpecialEffect.COLOR_WISH));
        cardRepository.save(new Card(Color.BLACK, SpecialEffect.DRAW_FOUR_COLOR_WISH));
        cardRepository.save(new Card(Color.BLACK, SpecialEffect.COLOR_WISH));

        // RED CARDS 2
        cardRepository.save(new Card(Color.RED, Numeration.ZERO));
        cardRepository.save(new Card(Color.RED, Numeration.ONE));
        cardRepository.save(new Card(Color.RED, Numeration.TWO));
        cardRepository.save(new Card(Color.RED, Numeration.THREE));
        cardRepository.save(new Card(Color.RED, Numeration.FOUR));
        cardRepository.save(new Card(Color.RED, Numeration.FIVE));
        cardRepository.save(new Card(Color.RED, Numeration.SIX));
        cardRepository.save(new Card(Color.RED, Numeration.SEVEN));
        cardRepository.save(new Card(Color.RED, Numeration.EIGHT));
        cardRepository.save(new Card(Color.RED, Numeration.NINE));
        cardRepository.save(new Card(Color.RED, SpecialEffect.SKIP));
        cardRepository.save(new Card(Color.RED, SpecialEffect.REVERSE));
        cardRepository.save(new Card(Color.RED, SpecialEffect.DRAW_TWO));


        // BLUE CARDS 2
        cardRepository.save(new Card(Color.BLUE, Numeration.ZERO));
        cardRepository.save(new Card(Color.BLUE, Numeration.ONE));
        cardRepository.save(new Card(Color.BLUE, Numeration.TWO));
        cardRepository.save(new Card(Color.BLUE, Numeration.THREE));
        cardRepository.save(new Card(Color.BLUE, Numeration.FOUR));
        cardRepository.save(new Card(Color.BLUE, Numeration.FIVE));
        cardRepository.save(new Card(Color.BLUE, Numeration.SIX));
        cardRepository.save(new Card(Color.BLUE, Numeration.SEVEN));
        cardRepository.save(new Card(Color.BLUE, Numeration.EIGHT));
        cardRepository.save(new Card(Color.BLUE, Numeration.NINE));
        cardRepository.save(new Card(Color.BLUE, SpecialEffect.SKIP));
        cardRepository.save(new Card(Color.BLUE, SpecialEffect.REVERSE));
        cardRepository.save(new Card(Color.BLUE, SpecialEffect.DRAW_TWO));


        // GREEN CARDS 2
        cardRepository.save(new Card(Color.GREEN, Numeration.ZERO));
        cardRepository.save(new Card(Color.GREEN, Numeration.ONE));
        cardRepository.save(new Card(Color.GREEN, Numeration.TWO));
        cardRepository.save(new Card(Color.GREEN, Numeration.THREE));
        cardRepository.save(new Card(Color.GREEN, Numeration.FOUR));
        cardRepository.save(new Card(Color.GREEN, Numeration.FIVE));
        cardRepository.save(new Card(Color.GREEN, Numeration.SIX));
        cardRepository.save(new Card(Color.GREEN, Numeration.SEVEN));
        cardRepository.save(new Card(Color.GREEN, Numeration.EIGHT));
        cardRepository.save(new Card(Color.GREEN, Numeration.NINE));
        cardRepository.save(new Card(Color.GREEN, SpecialEffect.SKIP));
        cardRepository.save(new Card(Color.GREEN, SpecialEffect.REVERSE));
        cardRepository.save(new Card(Color.GREEN, SpecialEffect.DRAW_TWO));

        // YELLOW CARDS 2
        cardRepository.save(new Card(Color.YELLOW, Numeration.ZERO));
        cardRepository.save(new Card(Color.YELLOW, Numeration.ONE));
        cardRepository.save(new Card(Color.YELLOW, Numeration.TWO));
        cardRepository.save(new Card(Color.YELLOW, Numeration.THREE));
        cardRepository.save(new Card(Color.YELLOW, Numeration.FOUR));
        cardRepository.save(new Card(Color.YELLOW, Numeration.FIVE));
        cardRepository.save(new Card(Color.YELLOW, Numeration.SIX));
        cardRepository.save(new Card(Color.YELLOW, Numeration.SEVEN));
        cardRepository.save(new Card(Color.YELLOW, Numeration.EIGHT));
        cardRepository.save(new Card(Color.YELLOW, Numeration.NINE));
        cardRepository.save(new Card(Color.YELLOW, SpecialEffect.SKIP));
        cardRepository.save(new Card(Color.YELLOW, SpecialEffect.REVERSE));
        cardRepository.save(new Card(Color.YELLOW, SpecialEffect.DRAW_TWO));

        // SPECIAL CARDS 2
        cardRepository.save(new Card(Color.BLACK, SpecialEffect.DRAW_FOUR_COLOR_WISH));
        cardRepository.save(new Card(Color.BLACK, SpecialEffect.COLOR_WISH));
        cardRepository.save(new Card(Color.BLACK, SpecialEffect.DRAW_FOUR_COLOR_WISH));
        cardRepository.save(new Card(Color.BLACK, SpecialEffect.COLOR_WISH));


        //Players (Comment out if you want to start with empty player list)

        playerRepository.save(new Player("Player 1"));
        playerRepository.save(new Player("Player 2"));
        playerRepository.save(new Player("Player 3"));
        playerRepository.save(new Player("Player 4"));

    }
}
