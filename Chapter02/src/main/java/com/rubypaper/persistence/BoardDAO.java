package com.rubypaper.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Repository DB연동을 담당한다.
@Repository
public class BoardDAO {
	private String BOARD_INSERT  ="insert into board(seq, title, writer, content) values((select max(seq)+1 from board), ?, ?, ?)";
	private String BOARD_LIST  ="select * from board order by seq desc";

	@Autowired
	//jdbc객체는 스프링 부트가 제공하는 autoconfiguration에 의해 메모리에 뜬다.
	private JdbcTemplate spring;

	//글 등록 
	public void insertBoard(Map<String,Object>board) {
		spring.update(BOARD_INSERT, board.get("TITLE"),board.get("WRITER"),board.get("CONTENT"));
	}
	
	//글 검색
	public List<Map<String, Object>> getBoarderList(){
		return spring.queryForList(BOARD_LIST);
	}
}
