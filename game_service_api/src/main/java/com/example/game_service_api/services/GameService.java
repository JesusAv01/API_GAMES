package com.example.game_service_api.services;

import com.example.game_service_api.controllers.commons.entities.Game;

public interface GameService  {
     Game saveGame(Game gameRequest);

    Game getGameById(String id);
}
