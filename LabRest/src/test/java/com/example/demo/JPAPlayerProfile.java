package com.example.demo;

import com.example.labrest.model.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JPAPlayerProfile {
    public static void main(String[] args) {
        // Создаём EntityManager для работы с базой данных
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        // Создаём новый объект сущности
        Player player1 = new Player(4620,"Razor","Иван");

        // Сохраняем объект в базу данных
        em.getTransaction().begin();
        em.persist(player1);
        em.getTransaction().commit();

        // Извлекаем объект по ID
        Player findPlayer = em.find(Player.class, player1.getPlayerId());
        System.out.println("Найден пользователь: "+findPlayer.getPlayerId() +" " + findPlayer.getName()+" "+findPlayer.getRating());

        List<Player> players = em.createQuery("select p from Player p").getResultList();

        for(Player p : players) {
            System.out.println(p.getName());
        }

        em.close();
        emf.close();
    }
}