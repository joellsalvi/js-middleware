package br.com.middleware.exception;

public class UnauthorizedIntegrationException extends BaseIntegrationException {

    public UnauthorizedIntegrationException(String message, Integer httpStatus, String responseBody,
                                            String module) {
        super(message, httpStatus, responseBody, module);
    }

    public UnauthorizedIntegrationException(Integer httpStatus, String responseBody, String module) {
        super(httpStatus, responseBody, module);
    }
}
