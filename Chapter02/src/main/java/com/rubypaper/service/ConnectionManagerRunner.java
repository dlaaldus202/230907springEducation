package com.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.jdbc.ConnectionManager;

@Service
public class ConnectionManagerRunner implements ApplicationRunner {
	
	// BoardAutoConfiguration이 생성한 ConnectionManager 객체를 의존성 주입한다.
	@Autowired
	private ConnectionManager manager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("생성된 ConnectionManager 정보 : " + manager.toString());
	}

}
