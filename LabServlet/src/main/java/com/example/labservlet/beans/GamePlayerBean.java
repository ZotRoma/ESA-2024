
package com.example.labservlet.beans;

import com.example.labservlet.entities.Game;
import com.example.labservlet.entities.PlayerGameStatistic;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;


public class GamePlayerBean {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public void createGamePlayer(PlayerGameStatistic pgs) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(pgs);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void updateGamePlayer(PlayerGameStatistic pgs) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(pgs);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void removeGamePlayer(Integer id) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            PlayerGameStatistic pgs = em.find(PlayerGameStatistic.class, id);
            if(pgs != null){
                em.remove(pgs);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public PlayerGameStatistic findGamePlayer(Integer id) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(PlayerGameStatistic.class, id);
        } finally {
            em.close();
        }
    }
    public List<PlayerGameStatistic> findAllGamePlayer() {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT g FROM PlayerGameStatistic g", PlayerGameStatistic.class).getResultList();
        }finally {
            em.close();
        }
    }

    public List<PlayerGameStatistic> findAllGamePlayerByGameId(Integer gameId) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT g FROM PlayerGameStatistic g WHERE g.game = :gameId", PlayerGameStatistic.class)
                    .setParameter("gameId", gameId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<PlayerGameStatistic> findAllGamePlayerByPlayerId(Integer playerId) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT g FROM PlayerGameStatistic g WHERE g.player = :playerId", PlayerGameStatistic.class)
                    .setParameter("playerId", playerId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<PlayerGameStatistic> findAllGamePlayerByPlayerIdAndGameId(Integer playerId, Integer gameId) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT g FROM PlayerGameStatistic g WHERE g.player = :playerId and g.game = :gameId", PlayerGameStatistic.class)
                    .setParameter("playerId", playerId)
                    .setParameter("gameId", gameId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
