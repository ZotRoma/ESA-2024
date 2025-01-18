package com.example.labrest.controller;


import com.example.labrest.helper.GameList;
import com.example.labrest.helper.Helper;
import com.example.labrest.model.Game;
import com.example.labrest.request.GameRequest;
import com.example.labrest.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_HTML_VALUE})
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<Object> showGames(@RequestHeader("Accept") String acceptHeader) {
        List<Game> allGames = gameService.findAllGames();
        GameList gameList = new GameList();
        gameList.setGames(allGames);
        return Helper.response(gameList, acceptHeader, "/games.xslt", GameList.class);
    }



    @PostMapping
    public ResponseEntity<Object> addGame(@RequestBody GameRequest gameRequest, @RequestHeader("Accept") String acceptHeader) {
        Game game = new Game();
        game.setWhoWin(gameRequest.getWhoWin());
        game.setNumberKillsRadiant(gameRequest.getNumberKillsRadiant());
        game.setNumberKillsDire(gameRequest.getNumberKillsDire());
        game.setTime(gameRequest.getTime());
        gameService.createGame(game);

        return Helper.response(game, acceptHeader, "/games.xslt", Game.class);
    }

    @PutMapping
    public ResponseEntity<Object> updateGame(@RequestBody GameRequest gameRequest, @RequestHeader("Accept") String acceptHeader) {
        Game gameUpdate = gameService.findGame(gameRequest.getGameId());
        if (gameUpdate == null) {
            return ResponseEntity.status(404).body("Game not found"); // 404, если игра не найдена
        }
        gameUpdate.setWhoWin(gameRequest.getWhoWin());
        gameUpdate.setNumberKillsRadiant(gameRequest.getNumberKillsRadiant());
        gameUpdate.setNumberKillsDire(gameRequest.getNumberKillsDire());
        gameUpdate.setTime(gameRequest.getTime());
        gameService.updateGame(gameUpdate);

        return Helper.response(gameUpdate, acceptHeader, "/games.xslt", Game.class);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteGame(@RequestParam("id") Integer gameId, @RequestHeader("Accept") String acceptHeader) {
        Game gameDelete = gameService.findGame(gameId);
        if (gameDelete == null) {
            return ResponseEntity.status(404).body("Game not found");
        }
        System.out.println(gameDelete);
        gameService.removeGame(gameId);
        return Helper.response(gameDelete, acceptHeader, "/games.xslt", Game.class);
    }

}