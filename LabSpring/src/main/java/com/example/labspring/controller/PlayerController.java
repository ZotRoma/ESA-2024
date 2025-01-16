package com.example.labspring.controller;

import com.example.labspring.model.Player;
import com.example.labspring.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public String players(Model model) {
        List<Player> playersList = playerService.findAllPlayers();
        model.addAttribute("playersList", playersList);
        return "players";
    }

    @GetMapping("/editPlayer")
    public String editPlayer(@RequestParam("id") Integer playerId, Model model) {
        Player player = playerService.findPlayer(playerId);
        model.addAttribute("player", player);
        return "editPlayer";
    }

    @GetMapping("/addPlayer")
    public String showAddPlayerForm() {
        return "addPlayer"; // Форма для добавления игрока
    }

    @PostMapping("/addPlayer")
    public String addPlayer(@RequestParam("name") String name,
                            @RequestParam("rating") Integer rating,
                            @RequestParam("favoriteCharacterName") String favoriteCharacterName) {
        Player newPlayer = new Player();
        newPlayer.setName(name);
        newPlayer.setRating(rating);
        newPlayer.setFavoriteCharacterName(favoriteCharacterName);
        playerService.addPlayer(newPlayer);
        return "redirect:/players";
    }

    @GetMapping("/deletePlayer")
    public String removePlayer(@RequestParam("id") Integer playerId,
                               Model model) {
        playerService.removePlayer(playerId);
        model.addAttribute("contextTitle", "Удаление игрока");
        model.addAttribute("contextH2", "Игрок удален");
        model.addAttribute("contextParagraph", "Удаление игрока проведено успешно");
        model.addAttribute("contextLink", "Вернуться к списку игроков");
        model.addAttribute("returnLink", "players");
        return "success";
    }

    @PostMapping("/updatePlayer")
    public String updatePlayer(@RequestParam("id") Integer playerId,
                               @RequestParam("name") String name,
                               @RequestParam("rating") Integer rating,
                               @RequestParam("favoriteCharacterName") String favoriteCharacterName,
                               Model model) {
        Player playerUpdate = playerService.findPlayer(playerId);
        playerUpdate.setName(name);
        playerUpdate.setRating(rating);
        playerUpdate.setFavoriteCharacterName(favoriteCharacterName);
        playerService.updatePlayer(playerUpdate);

        model.addAttribute("contextTitle", "Обновление игрока");
        model.addAttribute("contextH2", "Игрок обновлен");
        model.addAttribute("contextParagraph", "Обновление игрока произведено успешно.");
        model.addAttribute("contextLink", "Вернуться к списку игроков");
        model.addAttribute("returnLink", "players");

        return "success";
    }

}
