package com.demo.crud.response;

public class StringResponse implements ApiResponse {
    private final String message;

    public StringResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}