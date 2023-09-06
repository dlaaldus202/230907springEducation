package com.rubypaper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rubypaper.service.BoardService;

//1. 모든종류의 객체를 생성해라 
//2. 서블릿 컨테이너를 모킹해라

@SpringBootTest(webEnvironment =  WebEnvironment.MOCK)
@AutoConfigureMockMvc //모킹된 서블릿 컨테이너에 목업하기 위해 필요한 설정
//@WebMvcTest 로 띄어도 된다.
class BoardControllerTest4 {
	
	// MockMvc 객체가 가짜 서블릿 컨테이너다.
	@Autowired
	private MockMvc mockMvc;
	
	//boardService 타입의 서비스 객체를 모킹해라 (실제로 BoardServiceImp 객체는 생성되지 않는다.)
	//boardServiceImp은 생성자는 생성이 안된다.
	//
	@MockBean
	private BoardService boardService;
	
	@Test
	void testHello() throws Exception {
		//BoardService가 가진 hello가 가진 hello 비즈니스 메소가 리턴할 값을 설정한다.
		when(boardService.hello("gurm")).thenReturn("hello : gurm");
		
		// HTTP(http://localhost:8080/hello?name=gurum) 요청을 전송한다.
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("name", "gurm"))
		
		// HTTP 응답 결과를 검증한다. 
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("hello : gurm"));
	}
	
	
	@Test
	void testGetBoard() throws Exception {
		//BoardService가 가진 getBoard 비즈니스 메소드가 리턴할 값을 설정한다. 
		Map<String ,Object> board = new HashMap<String, Object>();
		board.put("SEQ", 1);
		board.put("TITLE", "임시재목");
		board.put("WRITER", "임시작성자");
		board.put("CONTENT", "임시내용");
		
		//BoardService가 가진 hello가 가진 hello 비즈니스 메소가 리턴할 값을 설정한다.
		when(boardService.getBoard(1)).thenReturn(board);
	
		// HTTP(http://localhost:8080/hello?name=gurum) 요청을 전송한다.
		mockMvc.perform(get("/getBoard").param("seq", "1"))

		// HTTP 응답 결과를 검증한다. 
		//객체는 json으로 리턴을 한다.
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.WRITER").isNotEmpty())
		.andExpect(jsonPath("$.WRITER").value("임시작성자"))
		.andDo(print());//http의 응답과 요청을 확인 할수 있다.
	}

}





