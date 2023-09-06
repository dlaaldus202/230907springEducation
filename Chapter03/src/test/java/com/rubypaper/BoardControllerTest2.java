package com.rubypaper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ch.qos.logback.core.Context;

// @WebMvcTest의 기능
// 1. @Controller, @RestController가 붙은 객체만 메모리에 생성한다. 
// 2. 서블릿 컨테이너(MockMvc)를 모킹한다.
@WebMvcTest
class BoardControllerTest2 {
	
	// MockMvc 객체가 가짜 서블릿 컨테이너다.
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testHello() throws Exception {
		// HTTP(http://localhost:8080/hello?name=gurum) 요청을 전송한다.
		mockMvc.perform(get("/hello").param("name", "gurum"))
		// HTTP 응답 결과를 검증한다. 
		.andExpect(status().isOk())
		.andExpect(content().string("hello : gurum"));
		//.andExpect(content().string("hello : gurum"));
	}

}





