package com.oodles.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MysqlDataSource {
    @Autowired
    private EnvConfiguration envConfig;

    @Bean
    public DataSource dataSource() {

        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setUrl(envConfig.getMySqlDBUrl());
        //poolProperties.setDriverClassName(envConfig.getMySqlDBDriver());
        poolProperties.setUsername(envConfig.getMySqlDBUser());
        poolProperties.setPassword(envConfig.getMySqlDBPassword().trim());
        poolProperties.setJmxEnabled(true);
        poolProperties.setTestWhileIdle(true);
        poolProperties.setTestOnBorrow(true);
        /*
         * poolProperties.setValidationQuery("SELECT 1");
         * poolProperties.setTestOnReturn(false);
         * poolProperties.setValidationInterval(30000);
         * poolProperties.setTimeBetweenEvictionRunsMillis(30000);
         * poolProperties.setMaxActive(Integer.parseInt(configuration.
         * getMaxAcitveConnection()));
         * poolProperties.setInitialSize(Integer.parseInt(configuration.
         * getDatabaseInitialConnectionSize())); poolProperties.setMaxWait(10000);
         * poolProperties.setRemoveAbandonedTimeout(120);
         * poolProperties.setMinEvictableIdleTimeMillis(30000);
         * poolProperties.setMinIdle(Integer.parseInt(configuration.getMinIdleConnection
         * ())); poolProperties.setLogAbandoned(true);
         * poolProperties.setRemoveAbandoned(true); poolProperties.setJdbcInterceptors(
         * "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
         * "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
         */
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(poolProperties);

        return datasource;
    }
}
