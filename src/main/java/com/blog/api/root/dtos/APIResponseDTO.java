package com.blog.api.root.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponseDTO<T> {
    private boolean error;
    private HttpStatus status;
    private String message;
    private T data;

    public APIResponseDTO(boolean error, HttpStatus status, String message, T data) {
        this.error = error;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> APIResponseDTO<T> success(HttpStatus status, String message, T data) {
        return new APIResponseDTO<>(false, status, message, data);
    }

    public static <T> APIResponseDTO<T> error(HttpStatus status, String message, T data) {
        return new APIResponseDTO<>(true, status, message, data);
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
