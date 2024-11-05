package com.example.labservlet.beans;

import com.example.labservlet.entities.Game;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;


public class GameBean {


    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public void createGame(Game game){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(game);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public void updateGame(Game game){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            game = em.merge(game);
            em.getTransaction().commit();
        }finally {
            em.close();
        }

    }
    public void removeGame(Integer gameId){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Game game = em.find(Game.class, gameId);
            if(game != null){
                em.createQuery("DELETE FROM PlayerGameStatistic pgs WHERE pgs.game = :game")
                        .setParameter("game", game)
                        .executeUpdate();
                em.remove(game);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public Game findGame(Integer gameId){
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Game.class, gameId);
        }finally {
            em.close();
        }
    }

    public List<Game> findAllGames(){
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT g FROM Game g", Game.class).getResultList();
        } finally {
            em.close();
        }
    }

}
