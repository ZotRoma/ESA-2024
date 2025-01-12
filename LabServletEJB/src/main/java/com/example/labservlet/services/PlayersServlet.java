package com.example.labservlet.services;

import com.example.labservlet.beans.PlayerBean;
import com.example.labservlet.entities.Player;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/players")
public class PlayersServlet extends HttpServlet {
    @EJB
    private PlayerBean playerBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Player> playersList = playerBean.findAllPlayers();

        request.setAttribute("playersList", playersList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/players.jsp");
        dispatcher.forward(request, response);
    }
}