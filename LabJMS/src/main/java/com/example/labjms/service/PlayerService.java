package com.example.labjms.service;

import com.example.labjms.model.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlayerService {

    @PersistenceContext
    private EntityManager entityManager;

    public void addPlayer(Player player) {
        entityManager.persist(player);
    }

    public void removePlayer(Integer playerId) {
        Player player = entityManager.find(Player.class, playerId);
        if (player != null) {
            entityManager.createQuery("DELETE FROM PlayerGameStatistic pgs WHERE pgs.player = :player")
                    .setParameter("player", player)
                    .executeUpdate();
            entityManager.remove(player);
        }
    }

    public void updatePlayer(Player player) {
        entityManager.merge(player);
    }

    public Player findPlayer(Integer playerId) {
        return entityManager.find(Player.class, playerId);
    }

    public List<Player> findAllPlayers() {
        List<Player> players = entityManager.createQuery("SELECT p FROM Player p", Player.class).getResultList();
        return players.isEmpty() ? new ArrayList<>() : players;
    }
}