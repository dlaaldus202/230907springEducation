package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubypaper.domain.Board;


//BoardRepository를 통해 CRUD 가능
//@Repository 필수는 아니다.
//@Repository와 @Mapper가 동일하다.
//CRUD는 JPA가 만들어 준다.
//★JpaRepository<Board, Integer> 설명
//Board 엔티티를 관리를 할거야 식별자 타입은 Integer
//이때 int가 아니라 Integer로 하는 이유는 기본형은 지원하지 않음
@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	//jqal
	//select b from Board AS b where b.title = :searchKeyword
	List<Board> findBoardByTitle(String searcKeyWord);
	
	//select b from Board AS b where b.title = :searchKeyword
	//List<Board> findByTitle(String searcKeyWord);
		
}
