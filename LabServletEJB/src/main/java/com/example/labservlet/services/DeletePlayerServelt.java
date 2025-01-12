package com.example.labservlet.services;

import com.example.labservlet.beans.PlayerBean;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deletePlayer")
public class DeletePlayerServelt extends HttpServlet {
    @EJB
    private PlayerBean playerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Отсутствует ID игрока");
            return;
        }
        playerBean.removePlayer(Integer.parseInt(idParam));
        request.setAttribute("contextTitle", "Удаление игрока");
        request.setAttribute("contextH2", "Игрок удален");
        request.setAttribute("contextParagraph", "Удаление игрока проведено успешно");
        request.setAttribute("contextLink", "Вернуться к списку игроков");
        request.setAttribute("returnLink", "players");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        dispatcher.forward(request, response);
    }


}
