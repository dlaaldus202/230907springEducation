package com.rubypaper;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

//자동설정 클래스로 띄운다.
//BoardRepository을 통해 의존성 주임 
//save() 영속상태로 만든다.
@SpringBootTest
class BoardRepositroyTest1 {

	@Autowired
	private BoardRepository boardRepository;

	//deleteById는 삭제할때 사용
	@Test
	void testDeleteBoard() {
		boardRepository.deleteById(1);
	}

	
	
	//save는 수정할때 사용
	//@Test
	void testUpdattBoard() {
		Board board = new Board();
		board.setSeq(1);
		board.setTitle("수정Title");
		board.setWriter("수정Writer");
		board.setContent("수정Content");
		board.setRegDate(new Date());
		boardRepository.save(board);
		
	}
	
	//상세조회 null값인 경우를 방지하기 위해 Optional
	//@Test
	void testGetBoard2() {
		//1.findXX()는 null 또는 Optional 타입으로 보낸다.
		Optional<Board> findBoard  = boardRepository.findById(1);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			System.out.println("검색결과:"+board.toString());	
		}
		
	}
	
	//상세조회
	//@Test
	void testGetBoard() {
		Board board = boardRepository.findById(1).get();
		System.out.println("검색결과:"+board.toString());	
	}
	
	//@Test
	void testInsertBoard() {
		Board board = new Board();
		board.setTitle("Title");
		board.setWriter("Writer");
		board.setContent("Content");
		board.setRegDate(new Date());
		boardRepository.save(board);
		
		
	}

}
