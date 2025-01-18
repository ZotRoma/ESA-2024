package com.example.labjms.service;

import com.example.labjms.model.Game;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameService {

    @PersistenceContext
    private EntityManager entityManager;

    public void createGame(Game game){
        entityManager.persist(game);
    }
    public void updateGame(Game game){
        entityManager.merge(game);
    }
    public void removeGame(Integer gameId){
        Game game = entityManager.find(Game.class, gameId);
        if(game != null) {
            entityManager.createQuery("DELETE FROM PlayerGameStatistic pgs WHERE pgs.game = :game")
                    .setParameter("game", game)
                    .executeUpdate();
            entityManager.remove(game);
        }

    }
    public Game findGame(Integer gameId){
        return entityManager.find(Game.class, gameId);
    }

    public List<Game> findAllGames(){
        return entityManager.createQuery("SELECT g FROM Game g", Game.class).getResultList();
    }

}
