package com.example.labservlet.services;

import com.example.labservlet.beans.GameBean;
import com.example.labservlet.entities.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/addGame")
public class AddGameServlet extends HttpServlet {
    protected final GameBean gameBean = new GameBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> optionsList = Arrays.asList("Dire", "Radiant","");
        req.setAttribute("optionsList", optionsList);
        req.getRequestDispatcher("addGame.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game newGame = new Game();
        newGame.setTime(Integer.parseInt(req.getParameter("Time")));
        newGame.setNumberKillsDire(Integer.parseInt(req.getParameter("NumberKillsDire")));
        newGame.setNumberKillsRadiant(Integer.parseInt(req.getParameter("NumberKillsRadiant")));
        newGame.setWhoWin(req.getParameter("WhoWin"));

        System.out.println(newGame.getGameId()+" "+newGame.getTime()+" "+newGame.getNumberKillsDire()+" "+newGame.getNumberKillsRadiant()+" "+newGame.getWhoWin());
        gameBean.createGame(newGame);


        resp.sendRedirect(req.getContextPath()+"/games");
    }
}
