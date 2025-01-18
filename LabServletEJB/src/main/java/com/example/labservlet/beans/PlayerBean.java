package com.example.labservlet.beans;

import com.example.labservlet.entities.Player;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class PlayerBean {

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