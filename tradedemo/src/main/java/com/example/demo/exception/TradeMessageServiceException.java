package com.example.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class TradeMessageServiceException extends RuntimeException {
    public TradeMessageServiceException() {
        super();
    }

    public TradeMessageServiceException(String message) {
        super(message);
    }

    public TradeMessageServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
