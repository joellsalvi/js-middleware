package br.com.middleware.api;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.middleware.exception.BadRequestIntegrationException;
import br.com.middleware.exception.BusinessIntegrationException;
import br.com.middleware.exception.NotFoundIntegrationException;
import br.com.middleware.exception.UnauthorizedIntegrationException;
import br.com.middleware.exception.UnexpectedIntegrationException;
import feign.Response;
import feign.codec.ErrorDecoder;

public abstract class AbstractErrorDecoder implements ErrorDecoder {

    protected Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    private String module;

    public AbstractErrorDecoder(String module) {
        this.module = module;
    }

    public String getModule() {
        return module;
    }

    protected Exception badRequestIntegrationException(Response response) {
        String body = getResponseBody(response);
        return badRequestIntegrationException(response, body);
    }

    protected Exception badRequestIntegrationException(Response response, String body) {
        LOGGER.warn(this.module + " - " + body);
        return new BadRequestIntegrationException(response.status(), body, this.module);
    }

    protected UnauthorizedIntegrationException unauthorizedIntegrationException(Response response) {
        String body = getResponseBody(response);
        LOGGER.warn(this.module + " - " + body);
        return new UnauthorizedIntegrationException("Unauthorized " + response.status(), response.status(), body, this
                .module);
    }

    protected NotFoundIntegrationException notFoundIntegrationException(Response response) {
        return new NotFoundIntegrationException(response.status(), this.module);
    }

    protected BusinessIntegrationException businessIntegrationException(Response response, String body) {
        LOGGER.warn(this.module + " - " + body);
        return new BusinessIntegrationException(response.status(), body, this.module);
    }

    protected UnexpectedIntegrationException unexpectedIntegrationException(Response response) {
        String body = getResponseBody(response);
        LOGGER.warn(this.module + " - " + body);
        return new UnexpectedIntegrationException("Internal Error", response.status(), body, this.module);
    }

    protected String getMethodName(String methodKey) {
        return methodKey.split("#")[1];
    }

    protected String getResponseBody(Response response) {
        try {
            if (response.body() == null)
                return null;
            return IOUtils.toString(response.body().asInputStream(), "UTF-8");
        } catch (IOException ex) {
            return ex.getLocalizedMessage();
        }
    }

//    protected <T> Optional<T> extractErrorResponse(String errorBody, Class<T> clazz) {
//        if (StringUtils.isNotBlank(errorBody)) {
//            T obj;
//
//            try {
//                obj = FeignUtils.customObjectMapper().readValue(errorBody, clazz);
//
//            } catch (IOException e) {
//                LOGGER.fatal(e.getMessage(), e);
//                return Optional.empty();
//            }
//
//            return Optional.of(obj);
//        }
//
//        return Optional.empty();
//    }
}
