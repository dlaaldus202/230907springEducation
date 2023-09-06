package com.rubypaper.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;

//@Service
public class BoadServiceWithMyBatis implements ApplicationRunner {

	//SqlSessionTemplate 객체가 Mybatis 컨테이너 이다.
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Board board = new Board();
		board.setTitle("MyBatis 제목");
		board.setWriter("MyBatis 작성자");
		board.setContent("MyBatis 내용");
		mybatis.insert("insertBoard",board);
		//id가 insertBoard인 객체를 통해서 insert()해줘라
		
		List<Board> boardList = mybatis.selectList("getBoardList");
		for(Board row : boardList) {
			System.out.println("--->"+row.toString());
		}
		//id가 getBoardList인 객체를 통해서 selectList() 해줘라
		
	}

}
