package com.example.game_service_api.controllers;

import com.example.game_service_api.controllers.commons.constants.ApiPathVariables;
import com.example.game_service_api.controllers.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//ENDPOINT /v1/games
@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public interface GameApi {
    @PostMapping
    ResponseEntity<Game> saveGame(@RequestBody Game game);
    @GetMapping("/{id}")
    ResponseEntity<Game>getGameById(@PathVariable String id);
    @PutMapping("/{id}")
    ResponseEntity<Game>updateGame(@PathVariable String id, @RequestBody Game newName);
    @DeleteMapping("/{id}")
    ResponseEntity<Game>deleteGame(@PathVariable String id);
}
