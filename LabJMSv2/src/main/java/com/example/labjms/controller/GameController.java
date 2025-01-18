package com.example.labjms.controller;


import com.example.labjms.enums.ChangeTypeEnum;
import com.example.labjms.enums.TablesEnum;
import com.example.labjms.helper.GameList;
import com.example.labjms.helper.Helper;
import com.example.labjms.jms.Sender;
import com.example.labjms.model.Game;
import com.example.labjms.model.Log;
import com.example.labjms.request.GameRequest;
import com.example.labjms.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/games",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_HTML_VALUE})
public class GameController {
    @Autowired
    private GameService gameService;

    private final Sender sender;

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
        System.out.println(gameRequest.toString());
        sender.send(
                Log.builder()
                        .changeType(ChangeTypeEnum.INSERT)
                        .table(TablesEnum.GAME)
                        .value(gameRequest.toString())
                        .datetime(LocalDateTime.now())
                        .build()
        );
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
        sender.send(
                Log.builder()
                        .changeType(ChangeTypeEnum.UPDATE)
                        .table(TablesEnum.GAME)
                        .value(gameRequest.toString())
                        .datetime(LocalDateTime.now())
                        .build()
        );
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
        sender.send(
                Log.builder()
                        .changeType(ChangeTypeEnum.DELETE)
                        .table(TablesEnum.GAME)
                        .value(gameDelete.getGameId().toString())
                        .datetime(LocalDateTime.now())
                        .build()
        );
        return Helper.response(gameDelete, acceptHeader, "/games.xslt", Game.class);
    }

}