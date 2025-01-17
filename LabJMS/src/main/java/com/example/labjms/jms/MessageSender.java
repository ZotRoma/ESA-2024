package com.example.labjms.jms;

import com.example.labjms.logging.ChangeType;
import jakarta.jms.MapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.logging.Logger;

@Component
public class MessageSender {
    private static final Logger logger = Logger.getLogger(MessageSender.class.getName());

    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendMessage(ChangeType changeType, String entityClass, Long entityId, Map<String, Object> fields) {
        logger.info("sending a message");

        jmsTemplate.send(session -> {

            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("changeType", changeType.toString());
            mapMessage.setString("entityClass", entityClass);
            mapMessage.setLong("entityId", entityId);

            for (Map.Entry<String, Object> entry : fields.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                mapMessage.setObject(key, value);
            }

            return mapMessage;
        });

    }

}
