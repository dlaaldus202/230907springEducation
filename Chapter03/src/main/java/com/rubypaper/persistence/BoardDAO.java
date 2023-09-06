package com.rubypaper.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	private String BOARD_GET  = "select * from board where seq = ?";
	private String BOARD_LIST = "select * from board order by seq desc";
		
	@Autowired
	// JdbcTemplate 객체는 스프링 부트가 제공하는 AutoConfiguration에 의해 메모리에 뜬다.
	private JdbcTemplate spring;
	
	// 글 상세 조회
	public Map<String, Object> getBoard(int seq) {
		Object[] args = {seq};
		return spring.queryForMap(BOARD_GET, args);
	}
	
	// 글 목록 검색
	public List<Map<String, Object>> getBoardList() {
		return spring.queryForList(BOARD_LIST);
	}
}









