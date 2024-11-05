package com.example.labservlet.services;

import com.example.labservlet.beans.PlayerBean;

import com.example.labservlet.entities.Player;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addPlayer")
public class AddPlayerServlet extends HttpServlet {

    private final PlayerBean playerBean = new PlayerBean();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Здесь можно указать путь к JSP-странице с формой
        request.getRequestDispatcher("addPlayer.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Player newPlayer = new Player();
        newPlayer.setName(request.getParameter("name"));
        newPlayer.setRating(Integer.parseInt(request.getParameter("rating")));
        newPlayer.setFavoriteCharacterName(request.getParameter("favoriteCharacterName"));
        System.out.println(newPlayer.getName()+" "+newPlayer.getRating()+" "+newPlayer.getFavoriteCharacterName());
        playerBean.addPlayer(newPlayer);
        response.sendRedirect(request.getContextPath() + "/players");
    }
}
