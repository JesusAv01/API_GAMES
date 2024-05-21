package com.example.game_service_api.services.impl;

import com.example.game_service_api.controllers.commons.entities.Game;
import com.example.game_service_api.controllers.commons.exceptions.GameException;
import com.example.game_service_api.repositories.GameRepository;
import com.example.game_service_api.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest) {
        try {
            Game gameCreated = this.gameRepository.save(gameRequest);
            return gameCreated;
        } catch (Exception e) {
            throw new GameException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while saving the game");
        }
    }


    @Override
    public Game getGameById(String id) {
        try {
            return this.gameRepository.findById(Long.valueOf(id))
                    .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "ERROR FINDING GAME"));
        } catch (NumberFormatException e) {
            throw new GameException(HttpStatus.BAD_REQUEST, "Invalid ID format: " + id);
        }
    }


    @Override
    public Game updateGame(String id, Game newName) {
        try {
            Long gameId = Long.valueOf(id);
            Optional<Game> existingGame = this.gameRepository.findById(gameId);

            if (existingGame.isEmpty()) {
                throw new GameException(HttpStatus.NOT_FOUND, "Game not found with ID: " + id);
            }

            Game gameToUpdate = existingGame.get();
            gameToUpdate.setName(newName.getName());

            Game updatedGame = this.gameRepository.save(gameToUpdate);
            return updatedGame;
        } catch (NumberFormatException e) {
            throw new GameException(HttpStatus.BAD_REQUEST, "Invalid ID format: " + id);
        } catch (GameException e) {
            throw e;
        } catch (Exception e) {
            throw new GameException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error occurred while updating game");
        }
    }

    @Override
    public Game deleteGame(String id) {
        try {
            Long gameId = Long.valueOf(id);
            Optional<Game> existingGame = this.gameRepository.findById(gameId);

            if (existingGame.isEmpty()) {
                throw new GameException(HttpStatus.NOT_FOUND, "Game not found with ID: " + id);
            }

            Game gameToDelete = existingGame.get();
            this.gameRepository.delete(gameToDelete);

            return gameToDelete;
        } catch (NumberFormatException e) {
            throw new GameException(HttpStatus.BAD_REQUEST, "Invalid ID format: " + id);
        } catch (GameException e) {
            throw e;
        } catch (Exception e) {
            throw new GameException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error occurred while deleting game");
        }
    }



}
