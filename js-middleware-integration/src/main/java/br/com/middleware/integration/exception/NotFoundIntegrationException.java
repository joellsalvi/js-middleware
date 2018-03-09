package br.com.middleware.integration.exception;

public class NotFoundIntegrationException extends BaseIntegrationException {

    private String messageKey;

    public NotFoundIntegrationException(String message, Integer httpStatus, String module) {
        super(message, httpStatus, module);
    }

    public NotFoundIntegrationException(Integer httpStatus, String module) {
        super(httpStatus, module);
    }

    public NotFoundIntegrationException(Integer httpStatus, String module, String messageKey) {
        super(httpStatus, module);
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
}
