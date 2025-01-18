package com.example.labservlet.services;

import com.example.labservlet.beans.GameBean;
import com.example.labservlet.beans.GamePlayerBean;
import com.example.labservlet.beans.PlayerBean;
import com.example.labservlet.entities.Game;
import com.example.labservlet.entities.Player;
import com.example.labservlet.entities.PlayerGameStatistic;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/addPlayerGame")
public class AddPlayerGameServlet extends HttpServlet {
    @EJB
    private GamePlayerBean gamePlayerBean;
    @EJB
    private GameBean gameBean;
    @EJB
    private PlayerBean playerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Player> players = playerBean.findAllPlayers();
        List<Game> games = gameBean.findAllGames();
        req.setAttribute("players", players);
        req.setAttribute("games", games);
        req.getRequestDispatcher("addPlayerGame.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlayerGameStatistic pgs = new PlayerGameStatistic();
        pgs.setGame(gameBean.findGame(Integer.parseInt(req.getParameter("Game"))));
        pgs.setPlayer(playerBean.findPlayer(Integer.parseInt(req.getParameter("Player"))));
        pgs.setKills(Integer.parseInt(req.getParameter("Kills")));
        pgs.setAssists(Integer.parseInt(req.getParameter("Assists")));
        pgs.setDeaths(Integer.parseInt(req.getParameter("Deaths")));
        pgs.setHeroName(req.getParameter("HeroName"));
        pgs.setLastHit(Integer.parseInt(req.getParameter("LastHit")));

        gamePlayerBean.createGamePlayer(pgs);
        resp.sendRedirect(req.getContextPath()+"/players_game");
    }
}
