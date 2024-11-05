package com.example.labservlet.services;


import com.example.labservlet.beans.GamePlayerBean;
import com.example.labservlet.entities.PlayerGameStatistic;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updatePlayerGame")
public class UpdatePlayerGameServlet extends HttpServlet {
    private final GamePlayerBean gpb = new GamePlayerBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("editPlayerGame.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if(idParam == null || idParam.isEmpty()){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Отсутствует Id");
            return;
        }
        try{
            PlayerGameStatistic pgs = gpb.findGamePlayer(Integer.parseInt(req.getParameter("id")));
            pgs.setKills(Integer.parseInt(req.getParameter("Kills")));
            pgs.setDeaths(Integer.parseInt(req.getParameter("Deaths")));
            pgs.setAssists(Integer.parseInt(req.getParameter("Assists")));
            pgs.setLastHit(Integer.parseInt(req.getParameter("LastHit")));
            gpb.updateGamePlayer(pgs);

            req.setAttribute("contextTitle", "Обновление статистики игрока в игре");
            req.setAttribute("contextH2", "Статистика игрока обновлена");
            req.setAttribute("contextParagraph", "Обновление статистики игрока произошло успешно");
            req.setAttribute("contextLink", "Вернуться к списку статистик игроков");
            req.setAttribute("returnLink", "players_game");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/success.jsp");
            dispatcher.forward(req, resp);
        }catch (NumberFormatException e){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }
}
