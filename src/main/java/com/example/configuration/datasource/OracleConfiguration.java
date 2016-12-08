package com.example.configuration.datasource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by a576097 on 18/08/2016.
 */
@Configuration
@ConfigurationProperties("h2")
public class OracleConfiguration {

    @Value("jdbc.userName:sa")
    private String userName;

    @Value("jdbc.password")
    private String password;

    @Value("jdbc.url:jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
    private String url;


    DataSource dataSource() throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUser(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
     }
}
