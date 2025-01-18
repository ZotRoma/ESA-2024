package com.example.labservlet.services;

import com.example.labservlet.beans.PlayerBean;
import com.example.labservlet.entities.Player;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updatePlayer")
public class UpdatePlayerServlet extends HttpServlet {

    @EJB
    private PlayerBean playerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Здесь можно указать путь к JSP-странице с формой
        request.getRequestDispatcher("editPlayer.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Player updatePlayer = playerBean.findPlayer(id);
        updatePlayer.setName(request.getParameter("name"));
        updatePlayer.setRating(Integer.parseInt(request.getParameter("rating")));
        updatePlayer.setFavoriteCharacterName(request.getParameter("favoriteCharacterName"));
        playerBean.updatePlayer(updatePlayer);

        request.setAttribute("contextTitle", "Обновление игрока");
        request.setAttribute("contextH2", "Игрок обновлен");
        request.setAttribute("contextParagraph", "Обновление игрока произведено успешно.");
        request.setAttribute("contextLink", "Вернуться к списку игроков");
        request.setAttribute("returnLink", "players");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        dispatcher.forward(request, response);


    }
}
