package br.com.middleware.application.config;

import br.com.middleware.ws.interception.AuthorizationInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * <pre> JS Middleware Aplication configuration class.
 * Used by the Spring IoC container as a source of bean definitions.
 * </pre>
 */
@Configuration
@ComponentScan(basePackages = {
        "br.com.middleware.ws",
        "br.com.middleware.service"
})
@PropertySource("classpath:application.properties")
public class JsMiddlewareApplicationConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor);
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("locale/messages");
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(false);
        return source;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new SmartLocaleResolver();
    }

    public class SmartLocaleResolver extends AcceptHeaderLocaleResolver {

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String languageHeader = request.getHeader("Accept-Language");

            if (StringUtils.isNotBlank(languageHeader)) {
                String[] locale = languageHeader.split("-");

                if (locale.length == 2) {
                    return new Locale(locale[0], locale[1]);
                }
            }

            return Locale.getDefault();
        }
    }

}
