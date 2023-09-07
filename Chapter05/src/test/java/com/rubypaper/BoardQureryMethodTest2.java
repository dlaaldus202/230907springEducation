package com.rubypaper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

//자동설정 클래스로 띄운다.
//BoardRepository을 통해 의존성 주임 
//save() 영속상태로 만든다.
@SpringBootTest
class BoardQureryMethodTest2 {

	@Autowired
	private BoardRepository boardRepository;

	//deleteById는 삭제할때 사용
	//@Test
	void testDeleteBoard() {
		boardRepository.deleteById(1);
	}
	
	@Test
	void testListBoard() {
		List<Board> boardList = boardRepository.findBoardByTitle("Title >> 17");
		
		System.out.println("검색결과");
		for(Board board : boardList) {
			System.out.println("board :"+board.toString());
		}
	}

	//Test 처음에 실행
	@BeforeEach
	void testInsertBoard() {
		for (int i = 0; i < 200 ; i++) {
			Board board = new Board();
			board.setTitle("Title >> "+i);
			board.setWriter("Writer >> "+i);
			board.setContent("Content >> "+i);
			board.setRegDate(new Date());
			board.setCnt(0);
			boardRepository.save(board);
		}
		
		
		
	}

}
