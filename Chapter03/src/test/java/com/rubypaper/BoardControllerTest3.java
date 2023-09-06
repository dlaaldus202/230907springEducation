package com.rubypaper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rubypaper.domain.BoardVO;

//1. @controller 뿐 아니라 @service @repository 모두 생성해라.
//2.RANDOM_PORT로 Tomcat 서버를 구동해라.
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BoardControllerTest3 {
	

	//TestRestTemplate 객체는 웹브라우저와 동일한 기능을 제공한다.
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	void testHello() throws Exception {
		//String.class 문자열이 리턴될꺼다.
		String result = restTemplate.getForObject("/hello?name=gurum", String.class);
		assertEquals("hello : gurum", result);
	}
	
	
	@Test
	void testGetBoard() throws Exception {
		//String.class 문자열이 리턴될꺼다.
		BoardVO result = restTemplate.getForObject("/getBoard", BoardVO.class);
		assertNotNull(result);
		assertEquals("1", result.getWriter());
	}
	
	@Test
	void testGetBoardList() throws Exception {
		//String.class 문자열이 리턴될꺼다.
		List<BoardVO> result = restTemplate.getForObject("/getBoardList", List.class);
		assertNotNull(result);
		assertEquals("6", result.size());
	}

}





