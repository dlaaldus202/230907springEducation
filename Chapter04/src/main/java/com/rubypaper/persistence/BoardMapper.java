package com.rubypaper.persistence;

import java.util.List;

import com.rubypaper.domain.Board;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper가 Boardmapper 인터페이스를 동적으로 생성한다.
//인터페이스를 구현한 클레스는  mybatiser가 자동으로 만들어준다.>> 구현클래스를 따로 안만들어도 된다.
//ex) @MockBean이랑 비슷하다.
@Mapper
public interface BoardMapper {
	
	@Insert(value = { "insert into board(seq, title, writer, content) values((select max(seq)+1 from board), #{title}, #{writer}, #{content})" })
	public void insertBoard(Board board);
	
	@Select(value = { "select * from board order by seq desc" })
	public List<Board> getBoardList();
	
}
