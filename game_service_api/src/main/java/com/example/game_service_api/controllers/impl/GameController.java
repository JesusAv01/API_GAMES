package com.example.game_service_api.controllers.impl;

import com.example.game_service_api.controllers.GameApi;
import com.example.game_service_api.controllers.commons.entities.Game;
import com.example.game_service_api.services.GameService;
import com.example.game_service_api.services.impl.GameServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController implements GameApi {

    private final GameService gameService;

    public GameController(GameService gameRepository) {
        this.gameService = gameRepository;
    }

    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        Game gamecreated = this.gameService.saveGame(game);
        return ResponseEntity.ok(gamecreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }
}
