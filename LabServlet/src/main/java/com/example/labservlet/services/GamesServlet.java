package com.example.labservlet.services;

import com.example.labservlet.beans.GameBean;
import com.example.labservlet.entities.Game;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/games")
public class GamesServlet extends HttpServlet {
    private final GameBean gameBean = new GameBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Game> gameList = gameBean.findAllGames();
        req.setAttribute("gameList", gameList);
        System.out.println(gameList.size());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/games.jsp");
        dispatcher.forward(req, resp);
    }
}
