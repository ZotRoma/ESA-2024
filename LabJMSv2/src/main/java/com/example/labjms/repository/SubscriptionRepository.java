package com.example.labjms.repository;

import com.example.labjms.model.Subscription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    @Override
    List<Subscription> findAll();
}
