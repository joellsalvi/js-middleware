package br.com.middleware.dataaccess.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Created by zup134 on 23/02/18.
 */
@Configuration
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
@EnableJpaRepositories(basePackages = "br.com.middleware.dataaccess.repository")
@PropertySource("classpath:data-access.properties")
public class DbConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(environment.getRequiredProperty("spring.datasource.driver-class-name"));
            ds.setJdbcUrl(getJdbcUrl());
            ds.setUser(environment.getRequiredProperty("spring.datasource.username"));
            ds.setPassword(environment.getRequiredProperty("spring.datasource.password"));
            ds.setMinPoolSize(Integer.valueOf(environment.getRequiredProperty("datasource.pool.minSize")));
            ds.setMaxPoolSize(Integer.valueOf(environment.getRequiredProperty("datasource.pool.maxSize")));
            ds.setAcquireIncrement(Integer.valueOf(environment.getRequiredProperty("datasource.pool.increment")));
            ds.setIdleConnectionTestPeriod(60);
            ds.setMaxStatements(100);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(new String[]{"br.com.zup.rw.claro.dataAccess.entity"});
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        return entityManagerFactoryBean;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.default_schema", getDefaultSchema());
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.show-sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    private String getJdbcUrl() {
        String url = environment.getRequiredProperty("spring.datasource.url");
        String appender = "";

        String schema = getDefaultSchema();
        if (!url.contains("currentSchema") && !StringUtils.isBlank(schema)) {
            appender += "currentSchema=" + schema;
        }

        if(!url.contains("?") && StringUtils.isNotBlank(appender)) {
            appender = "?".concat(appender);
        }

        return url.concat(appender);
    }

    private String getDefaultSchema() {
        return environment.getRequiredProperty("spring.jpa.properties.hibernate.default_schema");
    }
}
