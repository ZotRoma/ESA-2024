package com.example.labjms.service;

import com.example.labjms.logging.Notification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NotificationService {
    @PersistenceContext
    private EntityManager entityManager;

    public Notification getNotificationByEntityName(String entityName) {
        return entityManager.createNamedQuery("Notification.findByEntityName", Notification.class)
                .setParameter("name", entityName)
                .getSingleResult();
    }
}
