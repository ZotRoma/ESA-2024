package com.example.labjms.service;

import com.example.labjms.logging.ChangeLog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChangeLogService {
    @PersistenceContext
    private EntityManager entityManager;

    public void createLog(ChangeLog changeLog) {
        entityManager.persist(changeLog);
    }
}
