package com.example.labjms.jms;

import com.example.labjms.model.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Sender {
    private final JmsTemplate jmsTemplate;

    public void send(Log message) {
        jmsTemplate.convertAndSend("logger.q", message);
    }
}
