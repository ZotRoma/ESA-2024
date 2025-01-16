package com.example.labspring.controller;

import com.example.labspring.model.Game;
import com.example.labspring.model.Player;
import com.example.labspring.model.PlayerGameStatistic;
import com.example.labspring.service.GamePlayerService;
import com.example.labspring.service.GameService;
import com.example.labspring.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class PlayerGameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GamePlayerService gamePlayerService;

    @GetMapping("/")
    public String redirectToMenu(Model model) {
        return "index";
    }

    @GetMapping("/playersGames")
    public String showPlayersGames(Model model) {
        List<Game> gameList = gameService.findAllGames();
        List<Player> playerList = playerService.findAllPlayers();
        List<PlayerGameStatistic> gamePlayerList = gamePlayerService.findAllGamePlayer();
        model.addAttribute("gameList", gameList);
        model.addAttribute("playerList", playerList);
        model.addAttribute("playersGamesList", gamePlayerList);
        return "playersGames";
    }

    @GetMapping("/editPlayerGame")
    public String editPlayerGame(@RequestParam("id") Integer gamePlayerId, Model model) {
        PlayerGameStatistic playerGameStatistic = gamePlayerService.findGamePlayer(gamePlayerId);
        model.addAttribute("playerGame", playerGameStatistic);
        return "editPlayerGame";
    }
    @GetMapping("/addPlayerGame")
    public String showAddGameForm(Model model) {
        List<Game> gameList = gameService.findAllGames();
        List<Player> playerList = playerService.findAllPlayers();
        model.addAttribute("games", gameList);
        model.addAttribute("players", playerList);
        return "addPlayerGame"; // Форма для добавления игры
    }

    @PostMapping("/addPlayerGame")
    public String addPlayerGame(@RequestParam("Game") Integer GameId,
                                @RequestParam("Player") Integer PlayerId,
                                @RequestParam("HeroName") String HeroName,
                                @RequestParam("Kills") Integer Kills,
                                @RequestParam("Deaths") Integer Deaths,
                                @RequestParam("Assists") Integer Assists,
                                @RequestParam("LastHit") Integer LastHit
                                ) {
        PlayerGameStatistic playerGameStatistic = new PlayerGameStatistic();
        playerGameStatistic.setGame(gameService.findGame(GameId));
        playerGameStatistic.setPlayer(playerService.findPlayer(PlayerId));
        playerGameStatistic.setHeroName(HeroName);
        playerGameStatistic.setKills(Kills);
        playerGameStatistic.setDeaths(Deaths);
        playerGameStatistic.setAssists(Assists);
        playerGameStatistic.setLastHit(LastHit);

        gamePlayerService.createGamePlayer(playerGameStatistic);
        return "redirect:/playersGames";
    }

    @PostMapping("/updatePlayerGame")
    public String updatePlayer(@RequestParam("id") Integer PlayerGameId,
                               @RequestParam("Kills") Integer Kills,
                               @RequestParam("Deaths") Integer Deaths,
                               @RequestParam("Assists") Integer Assists,
                               @RequestParam("LastHit") Integer LastHit,
                               Model model) {
        PlayerGameStatistic playerGameStatistic = gamePlayerService.findGamePlayer(PlayerGameId);
        playerGameStatistic.setKills(Kills);
        playerGameStatistic.setDeaths(Deaths);
        playerGameStatistic.setAssists(Assists);
        playerGameStatistic.setLastHit(LastHit);
        gamePlayerService.updateGamePlayer(playerGameStatistic);

        model.addAttribute("contextTitle", "Обновление статистики игрока в игре");
        model.addAttribute("contextH2", "Статистика игрока обновлена");
        model.addAttribute("contextParagraph", "Обновление статистики игрока произошло успешно.");
        model.addAttribute("contextLink", "Вернуться к списку статистик игроков");
        model.addAttribute("returnLink", "playersGames");

        return "success";
    }


    @GetMapping("/deletePlayerGame")
    public String removePlayerGame(@RequestParam("id") Integer gamePlayerId, Model model) {
        gamePlayerService.removeGamePlayer(gamePlayerId);
        model.addAttribute("contextTitle", "Удаление статистики игрока");
        model.addAttribute("contextH2", "Статистика игрока удалена");
        model.addAttribute("contextParagraph", "Удаление статистики игры произошло успешно");
        model.addAttribute("contextLink", "Вернуться к списку статистик игроков");
        model.addAttribute("returnLink", "playersGames");

        return "success";
    }

}
