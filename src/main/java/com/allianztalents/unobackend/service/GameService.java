package com.allianztalents.unobackend.service;

import com.allianztalents.unobackend.entity.*;
import com.allianztalents.unobackend.entity.enumeration.RuleName;
import com.allianztalents.unobackend.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GameService {

  private final GameRepository gameRepository;
  private final DeckService deckService;
  private final ValidationService validationService;

  public Game insert(Game _game){
    return gameRepository.save(_game);
  }

  public List<Game> getGame(){
    return gameRepository.findAll();
  }

  public Game createGame(List<Player> players, List<Rule> rules) {

    Game game = new Game();

    game.setGameName("UNO 4 WINNERS");
    game.setRules(rules);
    game.setPlayers(players);
    game.setCurrentPlayer(players.get(0));
    game.setTurns(new ArrayList<>());
    game.setWinner(null);
    game.setClockwiseRotation(true);
    game.setDrawDeck(deckService.initializeDeck());
    game.setDeployDeck(new CardDeck());

    int startCardsValue = game.getRules().stream()
            .filter(rule -> rule.getRuleName().equals(RuleName.STARTCARDS) && rule.getRuleActive())
            .findFirst()
            .map(Rule::getRuleValue)
            .orElse(7);

    game.getPlayers().forEach(player -> {
      player.setCards(deckService.dealCards(game.getDrawDeck(),  startCardsValue));
    });

    return gameRepository.save(game);
  }

  public Game joinGame(Long gameId, Player player) {

    return null; // temporary
  }


  /**
    @param gameId Id des Spiels, in dem eine Karte gespielt werden soll
    @param playerId Id des Spielers, der eine Karte spielen möchte
    @param card Karte, die gespielt werden soll
    @return Game
    @throws Exception wenn die Karte nicht gespielt werden kann.
   **/
  public Game playCard(Long gameId, Long playerId, Card card) throws Exception {

    Game game = gameRepository.findById(gameId).orElseThrow();

    // Annahme: validateTurn gibt einen gültigen Turn zurück, der hinzugefügt werden soll.
    Turn validatedTurn = validationService.validateTurn(game, card);

    // Füge den validierten Turn zur Liste "turns" in "game" hinzu
    game.getTurns().add(validatedTurn);

    return gameRepository.save(game);
  }

  /**
   @param gameId Id des Spiels, in dem eine Karte gezogen werden soll
   @param playerId Id des Spielers, der eine Karte ziehen möchte
   @return Game
   @throws Exception wenn die Karte nicht gezogen werden kann.
  **/
  public Game drawCard(Long gameId, Long playerId) throws Exception {

    Game game = gameRepository.findById(gameId).orElseThrow();

    Turn validatedTurn = validationService.validateDrawTurn(game);

    //Der player zieht eine Karte vom obersten CardDeck des games
    Card card = new Card(game.getDrawDeck().getCards().get(0));
    game.getDrawDeck().getCards().remove(0);


    game.getPlayers().stream()
            .filter(p -> Objects.equals(p.getId(), playerId))
            .findFirst().orElseThrow()
            .getCards().add(card);

    game.getTurns().add(validatedTurn);

    return gameRepository.save(game) ;
  }

}
