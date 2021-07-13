package com.dailycodebuffer.spring.data.jpa.tutorial.Config;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DBConfig {

  @Autowired
  private Environment env;

  @Bean(name = "oracleDataSource")
//  @ConfigurationProperties("oracle")
  public DataSource dataSource() throws SQLException {
    DataSource pds = DataSourceBuilder
      .create()
      //     .driverClassName("oracle.jdbc.driver.OracleDriver")
      .url("jdbc:oracle:thin:@10.56.110.151:1521/testdb1")
      .username("voltsit5")
      .password("voltsit5")
      .build();

    //        pds.setFastConnectionFailoverEnabled(true);
    //        pds.setInitialPoolSize(5);
    //        pds.setMinPoolSize(5);
    //        pds.setMaxPoolSize(10);
    return pds;
  }
}
