package com.example.RideIt.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class Response<T>{
    T data;
    String message;
    int statusCode;

    public Response(T response, int value)
    {
        data=response;
        statusCode=value;
    }
}
