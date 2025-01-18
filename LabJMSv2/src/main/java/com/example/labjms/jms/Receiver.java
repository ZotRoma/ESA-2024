package com.example.labjms.jms;

import com.example.labjms.dto.LetterDto;
import com.example.labjms.enums.ChangeTypeEnum;
import com.example.labjms.model.Log;
import com.example.labjms.model.EventToSubscribe;
import com.example.labjms.model.Subscription;
import com.example.labjms.repository.EventToSubscribeRepository;
import com.example.labjms.repository.LogRepository;
import com.example.labjms.repository.SubscriptionRepository;
import com.example.labjms.service.SendEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class Receiver {
    private final LogRepository logRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final EventToSubscribeRepository eventToSubscribeRepository;
    private final SendEmailService sendEmailService;

    @JmsListener(destination = "logger.q")
    public void receive(Log message) {
        logRepository.save(message);
        //System.out.println("проверка работы");
        //System.out.println(subscriptionRepository.findAll().size());
        List<ChangeTypeEnum> eventToSubscribeList = eventToSubscribeRepository
                .findAll()
                .stream().map(EventToSubscribe::getEventType)
                .toList();

        if (! eventToSubscribeList.contains(message.getChangeType()))
            return;
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        List<LetterDto> letterDtoList = subscriptions
                .stream()
                .map((e) -> new LetterDto(message, e))
                .toList();
        System.out.println(letterDtoList.size());
        letterDtoList.forEach(sendEmailService::sendEmail);
    }
}
