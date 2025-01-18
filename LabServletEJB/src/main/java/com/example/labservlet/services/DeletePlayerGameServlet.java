package com.example.labservlet.services;

import com.example.labservlet.beans.GamePlayerBean;
import com.example.labservlet.entities.PlayerGameStatistic;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deletePlayerGame")
public class DeletePlayerGameServlet extends HttpServlet {
    @EJB
    private GamePlayerBean gpb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if(idParam == null || idParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        gpb.removeGamePlayer(Integer.parseInt(idParam));

        req.setAttribute("contextTitle", "Удаление статистики игрока");
        req.setAttribute("contextH2", "Статистика игрока удалена");
        req.setAttribute("contextParagraph", "Удаление статистики игры произошло успешно");
        req.setAttribute("contextLink", "Вернуться к списку статистик игроков");
        req.setAttribute("returnLink", "players_game");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/success.jsp");
        dispatcher.forward(req, resp);
    }
}
