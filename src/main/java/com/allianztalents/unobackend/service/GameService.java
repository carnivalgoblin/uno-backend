package com.allianztalents.unobackend.service;

import com.allianztalents.unobackend.entity.*;
import com.allianztalents.unobackend.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GameService {

  private GameRepository gameRepository;
  private DeckService deckService;
  private ValidationService validationService;

  public Game insert(Game _game){
    return gameRepository.save(_game);
  }

  public List<Game> getGame(){
    return gameRepository.findAll();
  }

  public Game createGame(List<Player> players) {

    Game game = new Game();

    game.setPlayers(players);

    List<Card> deck = deckService.initializeDeck();
    game.setDrawDeck((CardDeck) deck); //TODO Check which argument has to be used for this method

    return null;
  }

  public Game joinGame(Long gameId, Player player) {

    return null; // temporary
  }

  public Game playCard(Long gameId, Long playerId, Card card) throws Exception {

    Game game = gameRepository.findById(gameId).orElseThrow();

    // Annahme: validateTurn gibt einen gültigen Turn zurück, der hinzugefügt werden soll.
    Turn validatedTurn = validationService.validateTurn(game, card);

    // Füge den validierten Turn zur Liste "turns" in "game" hinzu
    game.getTurns().add(validatedTurn);

    return gameRepository.save(game);
  }

  public Game drawCard(Long gameId, Long playerId) throws Exception {

    Game game = gameRepository.findById(gameId).orElseThrow();

    Turn validatedTurn = validationService.validateDrawTurn(game);

    //Der player zieht eine Karte vom obersten CardDeck des games
    Card card = game.getDrawDeck().getCards().get(0);

    game.getPlayers().stream()
            .filter(p -> Objects.equals(p.getId(), playerId))
            .findFirst().orElseThrow()
            .getCards().add(card);

    game.getTurns().add(validatedTurn);

    return gameRepository.save(game) ;
  }

}
