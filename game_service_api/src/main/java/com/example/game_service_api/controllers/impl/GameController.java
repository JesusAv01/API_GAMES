package com.example.game_service_api.controllers.impl;

import com.example.game_service_api.controllers.GameApi;
import com.example.game_service_api.controllers.commons.entities.Game;
import com.example.game_service_api.services.GameService;
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
        return ResponseEntity.ok(this.gameService.saveGame(game));
    }

    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<Game> updateGame(String id, @RequestBody Game newName) {
        return ResponseEntity.ok(this.gameService.updateGame(id, newName));
    }

    @Override
    public ResponseEntity<Game> deleteGame(String id) {
        return ResponseEntity.ok(this.gameService.deleteGame(id));
    }


}
