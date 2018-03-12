package br.com.middleware.ws.interception;

import br.com.middleware.context.ApplicationContextHolder;
import br.com.middleware.ws.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private static final String X_ORGANIZATION_SLUG = "X-Organization-Slug";
    private static final String X_APPLICATION_ID = "X-Application-Id";
    private static final String INVALID_TENANT_HEADERS_MESSAGE = "X-Organization-Slug, X-Application-Id, X-Channel-Id are required.";
    private static final String X_CUSTOMER_ID = "X-Customer-Id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        String organizationSlug = request.getHeader(X_ORGANIZATION_SLUG);
        String applicationId = request.getHeader(X_APPLICATION_ID);
        String customerId = request.getHeader(X_CUSTOMER_ID);

        if (StringUtils.isBlank(organizationSlug)) {
            throw new ValidationException(INVALID_TENANT_HEADERS_MESSAGE);
        }

        if (StringUtils.isBlank(applicationId)) {
            throw new ValidationException(INVALID_TENANT_HEADERS_MESSAGE);
        }

        // ORGANIZATION_SLUG identificará qual cliente/organização está usando o aplicativo.
        // APPLICATION_ID identificará qual aplicação está efetuando a requisção.

        ApplicationContextHolder.getContext().setOrganization(organizationSlug);
        ApplicationContextHolder.getContext().setApplication(applicationId);
        ApplicationContextHolder.getContext().getCustom().put(X_CUSTOMER_ID, customerId);

        return super.preHandle(request, response, handler);
    }
}