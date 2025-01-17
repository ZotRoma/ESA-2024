package com.example.labjms.jms;

import org.springframework.util.ErrorHandler;

import java.util.logging.Logger;

public class DefaultErrorHandler implements ErrorHandler {

    private static final Logger logger = Logger.getLogger(DefaultErrorHandler.class.getName());
    // ... logger

    @Override
    public void handleError(Throwable t) {
        logger.warning("In default jms error handler...");
        logger.warning("Error Message : " + t.getMessage());
    }
}