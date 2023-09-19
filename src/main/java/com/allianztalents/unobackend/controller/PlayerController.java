package com.allianztalents.unobackend.controller;

import com.allianztalents.unobackend.entity.Player;
import com.allianztalents.unobackend.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

  @Autowired
  private PlayerRepository playerRepository;

  @PostMapping
  public Player addPlayer(@RequestBody Player player){
    return playerRepository.save(player);
  }

  @GetMapping
  public List<Player> getPlayers(){
    return playerRepository.findAll();
  }

}
