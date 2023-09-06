package com.rubypaper.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.ConnectionManager;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class BoardConfiguration {
	
	@Bean
	ConnectionManager connectionManager() {
		ConnectionManager manager = new ConnectionManager();
		manager.setDriverClass("org.h2.Driver");
		manager.setUrl("jdbc:h2:tcp://localhost/~/test02");
		manager.setUsername("sa");
		manager.setPassword("");
		return manager;
	}
	
	//Autoconfiguration이 생성하는 Datasource가 아닌 내가 생성한 DataSource를 사용하도록 설정한다. 
//	@Bean
//	DataSource dataSource() {
//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("");
//		
//		return dataSource;
//	}
}
