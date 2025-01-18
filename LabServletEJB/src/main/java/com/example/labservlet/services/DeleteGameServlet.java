package com.example.labservlet.services;

import com.example.labservlet.beans.GameBean;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteGame")
public class DeleteGameServlet extends HttpServlet {
    @EJB
    private GameBean gameBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        System.out.println(idParam);
        if (idParam == null || idParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Отсутствует ID игрока");
            return;
        }
        gameBean.removeGame(Integer.parseInt(idParam));
        req.setAttribute("contextTitle", "Удаление игры");
        req.setAttribute("contextH2", "Игра удалена");
        req.setAttribute("contextParagraph", "Удаление игры проведено успешно");
        req.setAttribute("contextLink", "Вернуться к списку игр");
        req.setAttribute("returnLink", "games");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/success.jsp");
        dispatcher.forward(req, resp);
    }
}
