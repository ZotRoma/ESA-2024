package com.example.labservlet.services;

import com.example.labservlet.beans.PlayerBean;
import com.example.labservlet.entities.Player;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editPlayer")
public class EditPlayerServlet extends HttpServlet {
    private final PlayerBean playerBean = new PlayerBean();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Отсутствует ID игрока");
            return;
        }

        try {
            Player player = playerBean.findPlayer(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("player", player);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/editPlayer.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный ID игрока");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Отсутствует ID игрока");
            return;
        }

        try {
            Integer id = Integer.parseInt(idParam);
            Player player = playerBean.findPlayer(id);
            if (player == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Игрок не найден");
                return;
            }
            request.setAttribute("player", player);
            request.getRequestDispatcher("editPlayer.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный ID игрока");
        }
    }
}
