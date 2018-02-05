package br.com.middleware.exception;

public class UnexpectedIntegrationException extends BaseIntegrationException {

    public UnexpectedIntegrationException(String message, Integer httpStatus,
                                          String responseBody, String module) {
        super(message, httpStatus, responseBody, module);
    }

    public UnexpectedIntegrationException(Integer httpStatus, String responseBody, String module) {
        super(httpStatus, responseBody, module);
    }
}
