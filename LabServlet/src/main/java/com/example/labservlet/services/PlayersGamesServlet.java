package com.example.labservlet.services;

import com.example.labservlet.beans.GamePlayerBean;
import com.example.labservlet.beans.PlayerBean;
import com.example.labservlet.entities.Player;
import com.example.labservlet.entities.PlayerGameStatistic;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/players_game")
public class PlayersGamesServlet extends HttpServlet {
    private final GamePlayerBean gamePlayerBean = new GamePlayerBean();
    private final PlayerBean playerBean = new PlayerBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PlayerGameStatistic> playersGamesList = gamePlayerBean.findAllGamePlayer();
        List<Player> players = playerBean.findAllPlayers();
        req.setAttribute("playersGamesList", playersGamesList);
        req.setAttribute("players", players);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/playersGames.jsp");
        dispatcher.forward(req, resp);
    }
}
