package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;
import com.rubypaper.service.BoardService;

//@Controller
@RestController //@Controller + ResponseBody
public class BoardController {
	
	//비즈니스 객체를 사용하는 Controller는 반드시 인터페이스를 이용해야한다.
	@Autowired
	private BoardService boardService;
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	//@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@GetMapping("/hello")
	//@ResponseBody : 리턴되는 문자열 문자열 그대로, 만약 객체라면 Json 데이터로 변환하여 http 응답프로토콜 Body에 출력
	public @ResponseBody String hello(String name) {
		return boardService.hello(name);
	}
	
	@GetMapping("/getBoard")
	public Map<String,Object> getBoard(int seq) {
		return boardService.getBoard(seq);
	}
	
	@GetMapping("/getBoardList")
	public List<Map<String, Object>> getBoardList() {
		return boardService.getBoardList();
	}
}
