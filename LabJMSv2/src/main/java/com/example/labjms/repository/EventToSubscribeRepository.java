package com.example.labjms.repository;

import com.example.labjms.model.EventToSubscribe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventToSubscribeRepository extends CrudRepository<EventToSubscribe, Long> {
    @Override
    List<EventToSubscribe> findAll();
}
