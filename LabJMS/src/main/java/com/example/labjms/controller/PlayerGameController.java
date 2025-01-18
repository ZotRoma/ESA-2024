package com.example.labjms.controller;

import com.example.labjms.helper.Helper;
import com.example.labjms.helper.PlayerGameStatisticList;
import com.example.labjms.model.PlayerGameStatistic;
import com.example.labjms.request.PlayerGameStatisticRequest;
import com.example.labjms.service.GamePlayerService;
import com.example.labjms.service.GameService;
import com.example.labjms.service.PlayerService;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value ="/playersGames",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_HTML_VALUE})
public class PlayerGameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GamePlayerService gamePlayerService;

    @GetMapping("xml")
    @Produces(MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<PlayerGameStatisticList> showPlayerGameXml() {
        List<PlayerGameStatistic> allPlayerGames = gamePlayerService.findAllGamePlayer();
        PlayerGameStatisticList playerGamesList = new PlayerGameStatisticList();
        playerGamesList.setPlayerGameStatisticList(allPlayerGames);
        return ResponseEntity.ok(playerGamesList);
    }

    @GetMapping
    public ResponseEntity<Object> showPlayerGame(@RequestHeader("Accept") String acceptHeader) {
//        List<PlayerGameStatistic> allPlayerGames = gamePlayerService.findAllGamePlayer();
//        PlayerGameStatisticList playerGamesList = new PlayerGameStatisticList();
//        playerGamesList.setPlayerGameStatisticList(allPlayerGames);
//        return Helper.response(playerGamesList, acceptHeader,"/players.xslt", PlayerGameStatistic.class);
//
        List<PlayerGameStatistic> allPlayerGameStatistic = gamePlayerService.findAllGamePlayer();
        PlayerGameStatisticList playerGameStatisticList = new PlayerGameStatisticList();
        playerGameStatisticList.setPlayerGameStatisticList(allPlayerGameStatistic);
        return Helper.response(playerGameStatisticList,acceptHeader,"/playersGames.xslt",PlayerGameStatisticList.class);
    }

    @PostMapping
    public ResponseEntity<Object> addPlayerGame(@RequestBody PlayerGameStatisticRequest playerGameStatisticRequest, @RequestHeader("Accept") String acceptHeader) {
        PlayerGameStatistic playerGameStatistic = new PlayerGameStatistic();
        playerGameStatistic.setPlayer(playerService.findPlayer(playerGameStatisticRequest.getPlayerId()));
        playerGameStatistic.setGame(gameService.findGame(playerGameStatisticRequest.getGameId()));
        playerGameStatistic.setKills(playerGameStatisticRequest.getKills());
        playerGameStatistic.setAssists(playerGameStatisticRequest.getAssists());
        playerGameStatistic.setDeaths(playerGameStatisticRequest.getDeaths());
        playerGameStatistic.setHeroName(playerGameStatisticRequest.getHeroName());
        playerGameStatistic.setLastHit(playerGameStatisticRequest.getLastHit());
        gamePlayerService.createGamePlayer(playerGameStatistic);

        return Helper.response(playerGameStatistic,acceptHeader,"/playersGames.xslt", PlayerGameStatistic.class);
    }

    @PutMapping
    public ResponseEntity<Object> updatePlayerGame(@RequestBody PlayerGameStatisticRequest playerGameStatisticRequest, @RequestHeader("Accept") String acceptHeader) {
        PlayerGameStatistic playerGameStatisticUpdate = gamePlayerService.findGamePlayer(playerGameStatisticRequest.getPlayerGameId());
        if (playerGameStatisticUpdate == null) {
            return ResponseEntity.status(404).body("Player statistic not found"); // 404, если игра не найдена
        }
        playerGameStatisticUpdate.setKills(playerGameStatisticRequest.getKills());
        playerGameStatisticUpdate.setAssists(playerGameStatisticRequest.getAssists());
        playerGameStatisticUpdate.setDeaths(playerGameStatisticRequest.getDeaths());
        playerGameStatisticUpdate.setHeroName(playerGameStatisticRequest.getHeroName());
        playerGameStatisticUpdate.setLastHit(playerGameStatisticRequest.getLastHit());
        gamePlayerService.updateGamePlayer(playerGameStatisticUpdate);

        return Helper.response(playerGameStatisticUpdate,acceptHeader,"/playersGames.xslt", PlayerGameStatistic.class);
    }

    @DeleteMapping
    public ResponseEntity<Object> deletePlayerGame(@RequestParam("id") Integer playerGameStatisticId, @RequestHeader("Accept") String acceptHeader) {
        PlayerGameStatistic playerGameStatisticDelete = gamePlayerService.findGamePlayer(playerGameStatisticId);
        if(playerGameStatisticDelete == null) {
            return ResponseEntity.status(404).body("Player statistic not found");
        }
        gamePlayerService.removeGamePlayer(playerGameStatisticId);
        return Helper.response(playerGameStatisticDelete,acceptHeader,"/playersGames.xslt", PlayerGameStatistic.class);
    }

}
