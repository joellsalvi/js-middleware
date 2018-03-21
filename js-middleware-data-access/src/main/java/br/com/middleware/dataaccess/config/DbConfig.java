package br.com.middleware.dataaccess.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;
import org.flywaydb.core.Flyway;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by zup134 on 23/02/18.
 */
@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
@EnableJpaRepositories(basePackages = "br.com.middleware.dataaccess.repository")
@PropertySource("classpath:data-access.properties")
public class DbConfig {

    @Autowired
    private Environment environment;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    /**
     * HEROKU DATASOURCE
     *
     * @return
     */
//    @Bean
//    public DataSource dataSource() {
//        if (dbUrl == null || dbUrl.isEmpty()) {
//            HikariDataSource ds = new HikariDataSource();
//            ds.setDriverClassName(environment.getRequiredProperty("datasource.driver.classname"));
//            ds.setJdbcUrl(getJdbcUrl());
//            ds.setUsername(environment.getRequiredProperty("datasource.username"));
//            ds.setPassword(environment.getRequiredProperty("datasource.password"));
//            ds.setMaximumPoolSize(Integer.valueOf(environment.getRequiredProperty("datasource.pool.maxSize")));
//            return ds;
//        } else {
//            HikariConfig config = new HikariConfig();
//            config.setJdbcUrl(dbUrl);
//            return new HikariDataSource(config);
//        }
//    }

    /**
     * LOCAL DATASOURCE
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        try {
            HikariDataSource ds = new HikariDataSource();
            ds.setDriverClassName(environment.getRequiredProperty("datasource.driver.classname"));
            ds.setJdbcUrl(getJdbcUrl());
            ds.setUsername(environment.getRequiredProperty("datasource.username"));
            ds.setPassword(environment.getRequiredProperty("datasource.password"));
            ds.setMaximumPoolSize(Integer.valueOf(environment.getRequiredProperty("datasource.pool.maxSize")));
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean(initMethod = "info")
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setBaselineDescription("JS Middleware Base Version");
        flyway.setBaselineVersionAsString("1");
        flyway.setTable("flyway_schema_history");
        flyway.setEncoding("UTF-8");
        flyway.setBaselineOnMigrate(true);
        flyway.setValidateOnMigrate(true);
        flyway.setSqlMigrationPrefix("V");
        flyway.setSqlMigrationSeparator("__");
        flyway.setSqlMigrationSuffixes(".sql");
        flyway.setOutOfOrder(false);
        flyway.setIgnoreMissingMigrations(false);
        flyway.setLocations("db/migration");
        flyway.setSchemas("js-middleware");//FIXME COMENTAR ESSA LINHA CASO USAR DATASOURCE DO HEROKU<<<<<<<<<<<<<<<
        flyway.setDataSource(dataSource());
        return flyway;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    @DependsOn("flyway")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(new String[]{"br.com.middleware.dataaccess.entity"});
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
        String url = environment.getRequiredProperty("datasource.url");
        String appender = "";

        String schema = getDefaultSchema();
        if (!url.contains("currentSchema") && !StringUtils.isBlank(schema)) {
            appender += "currentSchema=" + schema;
        }

        Boolean sslmode = getSslMode();
        if (sslmode) {
            if(url.contains("currentSchema")) {
                appender += "&";
            }
            appender += "sslmode=" + sslmode;
        }

        if(!url.contains("?") && StringUtils.isNotBlank(appender)) {
            appender = "?".concat(appender);
        }

        return url.concat(appender);
    }

    private String getDefaultSchema() {
        return environment.getRequiredProperty("spring.jpa.properties.hibernate.default_schema");
    }

    private Boolean getSslMode() {
        return Boolean.valueOf(environment.getRequiredProperty("datasource.sslmode"));
    }
}
