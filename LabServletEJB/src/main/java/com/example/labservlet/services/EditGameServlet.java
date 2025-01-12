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
import java.util.Arrays;
import java.util.List;

@WebServlet("/editGame")
public class EditGameServlet extends HttpServlet {
    @EJB
    private GameBean gameBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        try{
            Game game = gameBean.findGame(Integer.parseInt(req.getParameter("id")));
            List<String> optionsList = Arrays.asList("Dire", "Radiant","");
            req.setAttribute("optionsList", optionsList);
            req.setAttribute("game", game);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/editGame.jsp");
            dispatcher.forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный ID игры");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Отсутствует ID игры");
            return;
        }

        try{
            Game game = gameBean.findGame(Integer.parseInt(idParam));
            if (game == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Игра не найдена");
                return;
            }
            //List<String> optionsList = Arrays.asList("Dire", "Radiant","");
            //req.setAttribute("optionsList", optionsList);
            req.setAttribute("game", game);
            req.getRequestDispatcher("editGame.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный ID игры");
        }
    }
}
