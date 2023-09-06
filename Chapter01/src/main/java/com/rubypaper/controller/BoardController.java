package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

//@Controller
@RestController //@Controller + ResponseBody
public class BoardController {
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	//@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@GetMapping("/hello")
	//@ResponseBody : 리턴되는 문자열 문자열 그대로, 만약 객체라면 Json 데이터로 변환하여 http 응답프로토콜 Body에 출력
	public @ResponseBody String hello(String name) {
		return "hello : " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq('1');
		board.setTitle("1");
		board.setWriter("1");
		board.setCnt(1);
		return board;
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList= new ArrayList<BoardVO>();
		for(int i =0;i<=5;i++) {
			BoardVO board = new BoardVO();
			board.setSeq('1');
			board.setTitle("1");
			board.setWriter("1");
			board.setCnt(i);
			boardList.add(board);
		}
		
		return boardList;
	}
}
