package br.com.middleware.exception;

import java.util.Optional;

import org.springframework.util.Assert;

public abstract class BaseIntegrationException extends RuntimeException {

    private String module;
    private Integer httpStatus;
    private Optional<String> responseBody;

    public BaseIntegrationException(String message, Integer httpStatus, String responseBody, String module) {
        super(message);

        Assert.notNull(httpStatus, "HTTP Status is required!");
        Assert.notNull(module, "Module is required!");

        this.responseBody = Optional.ofNullable(responseBody);
        this.httpStatus = httpStatus;
        this.module = module;
    }

    public BaseIntegrationException(Integer httpStatus, String responseBody, String module) {
        super(module + " Integration Error");

        Assert.notNull(httpStatus, "HTTP Status is required!");
        Assert.notNull(module, "Module is required!");

        this.responseBody = Optional.ofNullable(responseBody);
        this.httpStatus = httpStatus;
        this.module = module;
    }

    public BaseIntegrationException(String message, Integer httpStatus, String module) {
        super(message);

        Assert.notNull(httpStatus, "HTTP Status is required!");
        Assert.notNull(module, "Module is required!");

        this.responseBody = Optional.empty();
        this.httpStatus = httpStatus;
        this.module = module;
    }

    public BaseIntegrationException(Integer httpStatus, String module) {
        super(module + " Integration Error");

        Assert.notNull(httpStatus, "HTTP Status is required!");
        Assert.notNull(module, "Module is required!");

        this.responseBody = Optional.empty();
        this.httpStatus = httpStatus;
        this.module = module;
    }

    public Optional<String> getResponseBody() {
        return responseBody;
    }

    public Integer getStatus() {
        return httpStatus;
    }

    public String getModule() {
        return module;
    }
}
