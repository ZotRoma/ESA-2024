package com.example.labjms.configuration;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsConfig {

    @Bean
    public ConnectionFactory connectionFactory() {

        InitialContext ctx;
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        // lookup the queue connection factory
        ConnectionFactory connFactory;
        try {
            connFactory = (ConnectionFactory) ctx.lookup("com/example/labjms/jms/ConnectionFactory");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        return connFactory;


    }

    @Bean
    public Destination destination() {
        InitialContext ctx;
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        try {
            return (Destination) ctx.lookup("com/example/labjms/jms/topic");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory, Destination destination) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setDefaultDestination(destination);
        jmsTemplate.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);

        return jmsTemplate;
    }

    @Bean(name="jmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true); // Set it to true for topics
        //factory.setErrorHandler(defaultErrorHandler);
        return factory;
    }
}