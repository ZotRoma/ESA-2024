package com.example.labspring.controller;

import com.example.labspring.model.Game;
import com.example.labspring.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

    @Controller
    public class GameController {
        @Autowired
        private GameService gameService;

        @GetMapping("/games")
        public String showGames(Model model) {
            List<Game> gameList = gameService.findAllGames();
            model.addAttribute("gameList", gameList);
            return "games";
        }

        @GetMapping("/editGame")
        public String editGame(@RequestParam("id") Integer gameId, Model model) {
            List<String> optionsList = Arrays.asList("Dire", "Radiant","");
            model.addAttribute("optionsList", optionsList);
            Game game = gameService.findGame(gameId);
            if (game == null) {
                // Обработка случая, когда игра не найдена
                return "error"; // или перенаправление на другую страницу
            }
            model.addAttribute("game", game);
            return "editGame";
        }

        @GetMapping("/addGame")
        public String showAddGameForm(Model model) {
            List<String> optionsList = Arrays.asList("Dire", "Radiant","");
            model.addAttribute("optionsList", optionsList);
            return "addGame"; // Форма для добавления игры
        }
        @PostMapping("/addGame")
        public String addGame(@RequestParam(value = "WhoWin", required = false) String whoWin,
                              @RequestParam(value = "NumberKillsRadiant", required = false) Integer numberKillsRadiant,
                              @RequestParam(value = "NumberKillsDire", required = false) Integer numberKillsDire,
                              @RequestParam(value = "Time", required = false) Integer time) {
            Game game = new Game();
            game.setWhoWin(whoWin);
            game.setNumberKillsDire(numberKillsDire);
            game.setNumberKillsRadiant(numberKillsRadiant);
            game.setTime(time);
            gameService.createGame(game);
            return "redirect:/games";
        }

        @GetMapping("/deleteGame")
        public String removeGame(@RequestParam("id") Integer gameId, Model model) {
            gameService.removeGame(gameId);
            model.addAttribute("contextTitle", "Удаление игры");
            model.addAttribute("contextH2", "Игра удалена");
            model.addAttribute("contextParagraph", "Удаление игры проведено успешно");
            model.addAttribute("contextLink", "Вернуться к списку игр");
            model.addAttribute("returnLink", "games");
            return "success";
        }

        @PostMapping("/updateGame")
        public String updateGame(@RequestParam("id") Integer gameId,
                                 @RequestParam(value = "WhoWin", required = false) String whoWin,
                                 @RequestParam(value = "NumberKillsRadiant", required = false) Integer numberKillsRadiant,
                                 @RequestParam(value = "NumberKillsDire", required = false) Integer numberKillsDire,
                                 @RequestParam(value = "Time", required = false) Integer time,
                                 Model model) {
            Game gameUpdate = gameService.findGame(gameId);
            if (gameUpdate == null) {
                // Обработка случая, когда игра не найдена
                return "error"; // или перенаправление на другую страницу
            }
            gameUpdate.setWhoWin(whoWin);
            gameUpdate.setNumberKillsDire(numberKillsDire);
            gameUpdate.setNumberKillsRadiant(numberKillsRadiant);
            gameUpdate.setTime(time);
            gameService.updateGame(gameUpdate);

            model.addAttribute("contextTitle", "Обновление игры");
            model.addAttribute("contextH2", "Игра обновлена");
            model.addAttribute("contextParagraph", "Обновление игры произошло успешно");
            model.addAttribute("contextLink", "Вернуться к списку игр");
            model.addAttribute("returnLink", "games");

            return "success";
        }
    }