package com.example.labservlet.services;

import com.example.labservlet.beans.GameBean;
import com.example.labservlet.entities.Game;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateGame")
public class UpdateGameServlet extends HttpServlet {
    @EJB
    private GameBean gameBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("editGame.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Отсутствует ID игры");
            return;
        }
        try {
            Integer gameId = Integer.parseInt(idParam);
            Game updateGame = gameBean.findGame(gameId);
            updateGame.setTime(Integer.parseInt(req.getParameter("Time")));
            updateGame.setNumberKillsDire(Integer.parseInt(req.getParameter("NumberKillsDire")));
            updateGame.setNumberKillsRadiant(Integer.parseInt(req.getParameter("NumberKillsRadiant")));
            updateGame.setWhoWin(req.getParameter("WhoWin"));

            gameBean.updateGame(updateGame);

            req.setAttribute("contextTitle", "Обновление игры");
            req.setAttribute("contextH2", "Игра обновлена");
            req.setAttribute("contextParagraph", "Обновление игры произошло успешно");
            req.setAttribute("contextLink", "Вернуться к списку игр");
            req.setAttribute("returnLink", "games");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/success.jsp");
            dispatcher.forward(req, resp);
        }catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Игра с таким ыid не найдена");
        }



    }
}
