package br.com.middleware.integration.exception;

public class BusinessIntegrationException extends BaseIntegrationException {

    public BusinessIntegrationException(String message, Integer httpStatus, String responseBody, String module) {
        super(message, httpStatus, responseBody, module);
    }

    public BusinessIntegrationException(Integer httpStatus, String responseBody, String module) {
        super(httpStatus, responseBody, module);
    }
}
