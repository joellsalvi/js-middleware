package br.com.middleware.integration.exception;

public class BadRequestIntegrationException extends BaseIntegrationException {

    public BadRequestIntegrationException(Integer httpStatus, String responseBody, String module) {
        super(httpStatus, responseBody, module);
    }
}
