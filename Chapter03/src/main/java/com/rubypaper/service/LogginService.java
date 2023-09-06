package com.rubypaper.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

//@compentscan을 위해서
@Service
public class LogginService implements ApplicationRunner {

	//slf4j 사용
	private Logger logger = LoggerFactory.getLogger(LogginService.class);
			
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		logger.error("error 레벨 로그");
		logger.warn("warn 레벨 로그");
		logger.info("info 레벨 로그");
		logger.debug("debug 레벨 로그");
		logger.trace("trace 레벨 로그");
	}

}
