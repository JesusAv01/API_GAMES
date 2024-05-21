package com.example.game_service_api.services.impl;

import com.example.game_service_api.controllers.commons.entities.Game;
import com.example.game_service_api.controllers.commons.exceptions.GameException;
import com.example.game_service_api.repositories.GameRepository;
import com.example.game_service_api.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest){
        Game gamecreated = this.gameRepository.save(gameRequest);
        return gamecreated;
    }

    @Override
    public Game getGameById(String id) {
        return this.gameRepository.findById(Long.valueOf(id))
            .orElseThrow(()-> new GameException(HttpStatus.NOT_FOUND,"ERROR FINDING GAME"));
    }


}
