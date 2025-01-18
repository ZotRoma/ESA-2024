
package com.example.labservlet.beans;

import com.example.labservlet.entities.Game;
import com.example.labservlet.entities.PlayerGameStatistic;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class GamePlayerBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void createGamePlayer(PlayerGameStatistic pgs) {
        entityManager.persist(pgs);
    }

    public void updateGamePlayer(PlayerGameStatistic pgs) {
        entityManager.merge(pgs);
    }

    public void removeGamePlayer(Integer id) {
        PlayerGameStatistic pgs = entityManager.find(PlayerGameStatistic.class, id);
        if(pgs != null){
            entityManager.remove(pgs);
        }
    }

    public PlayerGameStatistic findGamePlayer(Integer id) {
        return entityManager.find(PlayerGameStatistic.class, id);
    }
    public List<PlayerGameStatistic> findAllGamePlayer() {
        return entityManager.createQuery("SELECT g FROM PlayerGameStatistic g", PlayerGameStatistic.class).getResultList();
    }

    public List<PlayerGameStatistic> findAllGamePlayerByGameId(Integer gameId) {
        return entityManager.createQuery("SELECT g FROM PlayerGameStatistic g WHERE g.game = :gameId", PlayerGameStatistic.class)
                .setParameter("gameId", gameId)
                .getResultList();
    }

    public List<PlayerGameStatistic> findAllGamePlayerByPlayerId(Integer playerId) {
        return entityManager.createQuery("SELECT g FROM PlayerGameStatistic g WHERE g.player = :playerId", PlayerGameStatistic.class)
                .setParameter("playerId", playerId)
                .getResultList();
    }

    public List<PlayerGameStatistic> findAllGamePlayerByPlayerIdAndGameId(Integer playerId, Integer gameId) {
        return entityManager.createQuery("SELECT g FROM PlayerGameStatistic g WHERE g.player = :playerId and g.game = :gameId", PlayerGameStatistic.class)
                .setParameter("playerId", playerId)
                .setParameter("gameId", gameId)
                .getResultList();
    }

}
