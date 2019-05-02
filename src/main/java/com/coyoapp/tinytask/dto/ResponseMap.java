package com.coyoapp.tinytask.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Getter
@JsonPropertyOrder({"message", "response"})
public class ResponseMap<T> {

    private T response;

    public String message;

    ResponseMap() {
        //empty constructor for the jackson converter
    }

    public ResponseMap(@Nullable T response) {
        this.response = response;
    }

    public ResponseMap(String message) {
        this.message = message;
    }

    public ResponseMap(String message, @Nullable T response) {
        this.response = response;
        this.message = message;
    }
}
