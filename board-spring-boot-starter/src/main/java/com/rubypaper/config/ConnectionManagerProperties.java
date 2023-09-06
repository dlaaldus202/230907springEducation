package com.rubypaper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
// application.properties 파일에서 "board.datasource"라는 접두사로 시작하는 프로퍼티 정보를 추출하여
// 각 변수에(setXXX 메소드를 호출하여) 세팅해라.
@ConfigurationProperties(prefix = "board.jdbc")
public class ConnectionManagerProperties {
	
	private String driverClass;
	private String url;
	private String username;
	private String password;
	
	
	public ConnectionManagerProperties() {
		System.out.println("===> ConnectionManagerProperties 생성");
	}
}
