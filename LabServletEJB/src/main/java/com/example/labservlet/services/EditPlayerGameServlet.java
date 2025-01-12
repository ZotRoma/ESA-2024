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

@WebServlet("/editPlayerGame")
public class EditPlayerGameServlet extends HttpServlet {

    @EJB
    private GamePlayerBean gpb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        try{
            PlayerGameStatistic pgs = gpb.findGamePlayer(Integer.parseInt(req.getParameter("id")));
            if(pgs == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            req.setAttribute("playerGame",pgs);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/editPlayerGame.jsp");
            dispatcher.forward(req, resp);
        }catch (NumberFormatException e){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный ID");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        try{
            PlayerGameStatistic pgs = gpb.findGamePlayer(Integer.parseInt(req.getParameter("id")));
            if(pgs == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            req.setAttribute("playerGame",pgs);
            req.getRequestDispatcher("editPlayerGame.jsp").forward(req, resp);
        }catch (NumberFormatException e){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный ID");
        }
    }
}
