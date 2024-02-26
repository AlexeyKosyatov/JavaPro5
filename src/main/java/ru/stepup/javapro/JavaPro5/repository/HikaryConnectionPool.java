package ru.stepup.javapro.JavaPro5.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class HikaryConnectionPool {
    @Value("${database.driver-class-name}")
    String driverClassName;

    @Value("${database.jdbc-url}")
    String jdbcUrl;

    @Value("${database.username}")
    String username;

    @Value("${database.password}")
    String password;

    @Value("${database.maximum-pool-size}")
    int maximumPoolSize;


    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(maximumPoolSize);
        return new HikariDataSource(config);
    }

}
