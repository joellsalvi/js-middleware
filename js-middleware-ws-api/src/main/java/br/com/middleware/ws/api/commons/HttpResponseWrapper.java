package br.com.middleware.ws.api.commons;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResponseWrapper<T> {

    private T content;
    private String message;

    public HttpResponseWrapper(T content) {
        this.content = content;
    }
    public HttpResponseWrapper(T content, String message) {
        this.content = content;
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
