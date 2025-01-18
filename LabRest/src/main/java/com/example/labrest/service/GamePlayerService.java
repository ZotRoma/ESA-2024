
package com.example.labrest.service;

import com.example.labrest.model.PlayerGameStatistic;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GamePlayerService {

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
