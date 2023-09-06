package com.rubypaper.tv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		//1.spring 컨테이너 생성
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext("com.rubypaper.tv");
		//AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(TVConfiguration.class);
		
		//2.컨테이너 객체 lookup
		TV tv = (TV)container.getBean("tv");
		
		//3.lookup객체 이용S
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		//4.컨테이너 종료
		container.close();
				
		
		
		/*
		//1.spring 컨테이너 생성
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2.컨테이너 객체 lookup
		TV tv = (TV)container.getBean("tv");
		
		//3.lookup객체 이용S
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		//4.컨테이너 종료
		container.close();
		
		*/
	}

}
