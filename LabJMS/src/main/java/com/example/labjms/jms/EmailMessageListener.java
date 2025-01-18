package com.example.labjms.jms;

import com.example.labjms.logging.Notification;
import com.example.labjms.service.EmailService;
import com.example.labjms.service.NotificationService;
import jakarta.jms.JMSException;
import jakarta.jms.MapMessage;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class EmailMessageListener {

    private static final Logger logger = Logger.getLogger(EmailMessageListener.class.getName());

    private static Set<String> processedMessageIds = new HashSet<>();

    @Autowired
    NotificationService notificationService;

    @Autowired
    EmailService emailService;

    @JmsListener(destination = "topic", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message) {
        try {
            logger.info("got a message");
            if (message instanceof MapMessage) {
                MapMessage mapMessage = (MapMessage) message;
                String messageId = mapMessage.getJMSMessageID();

                if (processedMessageIds.contains(messageId)) {
                    logger.info("Duplicate message detected. Skipping processing.");
                    return;
                }

                String changeType = mapMessage.getString("changeType");
                String entityClass = mapMessage.getString("entityClass");
                Long entityId = mapMessage.getLong("entityId");

                Notification notification;

                try {
                    notification = notificationService.getNotificationByEntityName(entityClass);
                } catch (NoResultException ex) {
                    logger.info("No address found for this entity: " + entityClass);
                    return;
                }
                emailService.sendLogMessage(notification.getEmail(), changeType, entityClass, entityId);

                processedMessageIds.add(messageId);
            }
        } catch (JMSException e) {
            logger.severe("Error processing JMS message"+ e);
        }
    }
}
