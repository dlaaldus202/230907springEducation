package com.rubypaper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.ConnectionManager;

@Configuration
// ConnectionManagerProperties 클래스 객체를 생성해라. 
@EnableConfigurationProperties(ConnectionManagerProperties.class)
public class BoardAutoConfiguration {
	
	@Autowired
	private ConnectionManagerProperties properties;
	
	public BoardAutoConfiguration() {
		System.out.println("===> BoardAutoConfiguration 생성");
	}
	
	@Bean
	// 만약 메모리에 ConnectionManager 타입의 객체가 없다면 아래 메소드를 실행해라
	//@ConditionalOnMissingBean
	ConnectionManager connectionManager() {
		ConnectionManager manager = new ConnectionManager();
		manager.setDriverClass(properties.getDriverClass());
		manager.setUrl(properties.getUrl());
		manager.setUsername(properties.getUsername());
		manager.setPassword(properties.getPassword());
		return manager;
	}
}



