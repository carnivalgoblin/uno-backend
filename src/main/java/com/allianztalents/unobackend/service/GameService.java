package com.allianztalents.unobackend.service;

import com.allianztalents.unobackend.entity.*;
import com.allianztalents.unobackend.entity.enumeration.RuleName;
import com.allianztalents.unobackend.repository.GameRepository;
import com.allianztalents.unobackend.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GameService {

  private final GameRepository gameRepository;
  private final PlayerRepository playerRepository;
  private final DeckService deckService;
  private final ValidationService validationService;

  public List<Game> getGames(){
    return gameRepository.findAll();
  }

  /**
   * Erstellt ein neues Spiel
   * @param rules Liste der Regeln, die für das Spiel gelten
   * @return Game
   */
  public Game createGame(List<Rule> rules) {

    int requiredPlayerCount = 4;
    List<Player> players = playerRepository.findAll();

//    if (players.size() != requiredPlayerCount) {
//      throw new IllegalArgumentException("Es müssen " + requiredPlayerCount + " Spieler sein!");
//    }

    Game game = new Game();

    game.setGameName("UNO 4 WINNERS");
    game.setRules(rules);
    game.setPlayers(players);

    //Erster Spieler ist der aktuelle Spieler
    game.setCurrentPlayer(players.get(0));

    game.setTurns(new ArrayList<>());
    game.setWinner(null);
    game.setReverse(false);
    game.setDrawDeck(deckService.initializeDeck());
    game.setDeployDeck(new CardDeck());

    int startCardsValue = game.getRules().stream()
            .filter(rule -> rule.getRuleName().equals(RuleName.STARTCARDS) && rule.getRuleActive())
            .findFirst()
            .map(Rule::getRuleValue)
            .orElse(7);

    game.getPlayers().forEach(player -> player.setCards(deckService.dealCards(game.getDrawDeck(),  startCardsValue)));

    game.getDeployDeck().setCards(deckService.dealCards(game.getDrawDeck(), 1));

    return gameRepository.save(game);
  }


  /**
    @param gameId Id des Spiels, in dem eine Karte gespielt werden soll
    @param cardId ID von der Karte, die gespielt werden soll
    @return Game
    @throws Exception wenn die Karte nicht gespielt werden kann.
   **/
  public Game playCard(Long gameId, Long cardId) throws Exception {

    Game game = gameRepository.findById(gameId).orElseThrow();

    // Annahme: validateTurn gibt einen gültigen Turn zurück, der hinzugefügt werden soll.
    Turn validatedTurn = validationService.validateTurn(game, deckService.getCardById(cardId));

    // Füge den validierten Turn zur Liste "turns" in "game" hinzu
    game.getTurns().add(validatedTurn);

    deckService.placeCardOnDeckAndRemoveOnPlayer(game.getDeployDeck(), deckService.getCardById(cardId), game.getPlayerById(game.getCurrentPlayer().getId()));

    //Setze den nächsten Spieler!!!
    game.setCurrentPlayer(determineNextPlayer(game));

    return gameRepository.save(game);
  }

  /**
   @param gameId Id des Spiels, in dem eine Karte gezogen werden soll
   @return Game
  **/
  public Game drawCard(Long gameId, int cardamount) {

    Game game = gameRepository.findById(gameId).orElseThrow();

    List<Card> cards = deckService.dealCards(game.getDrawDeck(), cardamount);

    // Annahme: createDrawTurn gibt einen vorgefüllten Turn zurück, der hinzugefügt werden soll.
    Turn turn = validationService.createDrawTurn(game, cards);

    // Füge den vorgefüllten Turn zur Liste "turns" in "game" hinzu
    game.getTurns().add(turn);

    // Füge die gezogene Karte(n) zur Liste "cards" in "player" hinzu
    game.getPlayerById(game.getCurrentPlayer().getId()).getCards().addAll(cards);

    //Setze den nächsten Spieler!!!
    game.setCurrentPlayer(determineNextPlayer(game));

    return gameRepository.save(game) ;
  }

  /**
   * Die Funktion findet den nächsten Spieler, der an der Reihe ist.
   * @param game Game, in dem gespielt wird
   * @return Player, der als nächstes an der Reihe ist
   */
  private Player determineNextPlayer(Game game) {
    Card lastCard = ValidationService.validateLastPlayedCard(game);

    Player currentPlayer = game.getCurrentPlayer();

    int nextplayerindex= 1;

    // check if last turn was a skip or reverse
    switch (lastCard.getSpecialEffect()) {
      case SKIP -> // skip next
        nextplayerindex = 2;
      case REVERSE -> // before
        game.setReverse(!game.getReverse());
    }

    if (game.getReverse()) {
      if (game.getPlayers().indexOf(currentPlayer) == 0) {
        return game.getPlayers().get(game.getPlayers().size() - nextplayerindex);
      } else {
        return game.getPlayers().get(game.getPlayers().indexOf(currentPlayer) - nextplayerindex);
      }
    } else {
      if (game.getPlayers().indexOf(currentPlayer) == game.getPlayers().size() - nextplayerindex) {
        return game.getPlayers().get(0);
      } else {
        return game.getPlayers().get(game.getPlayers().indexOf(currentPlayer) + nextplayerindex);
      }

    }
  }

  public Game addPlayers(Long gameId, List<Player> players) {

    Game game = gameRepository.findById(gameId).orElseThrow();

    game.setPlayers(players);

    return gameRepository.save(game);

  }

  public Player addPlayer(String playername) {
    Player newPlayer = new Player(playername);

    return playerRepository.save(newPlayer);
  }

  public List<Player> getPlayers() {
    return playerRepository.findAll();
  }

  public int getNumberOfPlayers() {
    return playerRepository.findAll().size();
    }
}
