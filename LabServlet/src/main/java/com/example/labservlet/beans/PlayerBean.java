package com.example.labservlet.beans;

import com.example.labservlet.entities.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PlayerBean {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public void addPlayer(Player player) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(player);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void removePlayer(Integer playerId) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Player player = entityManager.find(Player.class, playerId);
            if (player != null) {
                entityManager.createQuery("DELETE FROM PlayerGameStatistic pgs WHERE pgs.player = :player")
                        .setParameter("player", player)
                        .executeUpdate();
                entityManager.remove(player);
            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void updatePlayer(Player player) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(player);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Player findPlayer(Integer playerId) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.find(Player.class, playerId);
        } finally {
            entityManager.close();
        }
    }

    public List<Player> findAllPlayers() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            List<Player> players = entityManager.createQuery("SELECT p FROM Player p", Player.class).getResultList();
            return players.isEmpty() ? new ArrayList<>() : players;
        } finally {
            entityManager.close();
        }
    }
}