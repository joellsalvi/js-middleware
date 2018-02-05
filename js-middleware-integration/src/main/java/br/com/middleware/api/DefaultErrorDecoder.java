package br.com.middleware.api;

import org.apache.commons.lang3.StringUtils;

import feign.Response;

public class DefaultErrorDecoder extends AbstractErrorDecoder {

    public DefaultErrorDecoder(String module) {
        super(module);
    }

    @Override
    public Exception decode(String s, Response response) {

        if (response.status() == 400) {
            return badRequestIntegrationException(response, getResponseBody(response));
        }

        if (response.status() == 401 || response.status() == 403) {
            return unauthorizedIntegrationException(response);
        }

        if (response.status() == 404) {
            String body = getResponseBody(response);
            if (StringUtils.isEmpty(body)) {
                return notFoundIntegrationException(response);
            }

            return businessIntegrationException(response, body);
        }

        if (response.status() == 422) {
            return businessIntegrationException(response, getResponseBody(response));
        }

        return unexpectedIntegrationException(response);
    }

}
