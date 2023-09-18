package com.allianztalents.unobackend.service;

import com.allianztalents.unobackend.entity.Game;
import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.entity.Card;
import com.allianztalents.unobackend.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;


  public Game insert(Game _game){
    return gameRepository.save(_game);
  }

  public List<Game> getGame(){
    return gameRepository.findAll();
  }

  public Game createGame(List<Player> players) {

    return null; // temporary
  }

  public Game joinGame(Long gameId, Player player) {

    return null; // temporary
  }

  public Game playCard(Long gameId, Long playerId, Card card) {

    return null; // temporary
  }

  public Game drawCard(Long gameId, Long playerId) {

    return null; // temporary
  }

}
