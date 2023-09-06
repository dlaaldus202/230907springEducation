package com.rubypaper.service;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

//SqlSessionTemplate 필요업음
//
@Service
public class BoadServiceWithJPA implements ApplicationRunner {

	
	//준영속 테스트2
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		tx.begin();
		Board board = new Board();
		board.setSeq(3);
		board.setTitle("JPA 제목 준영속2");
		//board.setWriter("JPA 작성자 준영속2");
		//board.setContent("JPA 내용 준영속2");
	
		//식별자값 X : merge()가 매개변수로 받은 객체에 식별자 변수값이 없으면 merge() Insert로 동작한다.
		//식별자값 O : merge()가 매개변수로 받은 객체에 식별자 변수값이 없으면 merge() Update로 동작한다.
		em.merge(board);
		tx.commit();
		
		em.close();
		emf.close();
	}
	
	/*
	//준영속 테스트1
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//상세조회
		Board finBoard = em.find(Board.class, 1);
		System.out.println("findBoard 영속상태인가(1)"+em.contains(finBoard));
		em.detach(finBoard);//준영속상태로 전환
		System.out.println("findBoard 영속상태인가(2)"+em.contains(finBoard));
		
		//준영속 객체의 값을 수정한다. 
		tx.begin();
		finBoard.setTitle("Title 수정!!!11");
		
		//merge()를 통해 영속상태로 전화
		//merge()메소드는 인자로 받은 엔티티의 복사본을 만들어 영속상태를 보내고 원래 객체는 계속 준영속상태로 유지한다.
		Board mergedBoard = em.merge(finBoard); //update
		//merge() 이후 객체 상태 확인
		System.out.println("findBoard는 영속상태인가? : "+ em.contains(finBoard));
		System.out.println("mergedBoard는 영속상태인가? : "+ em.contains(mergedBoard));
		tx.commit();
		
		em.close();
		emf.close();
	}*/
	
	/*
	//영속성 이해 Test 나의 
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
			
		//영속성에 위배되는 case1
		tx.begin();
		//수정할 게시글을 검색을 한다.
		Board board = em.find(Board.class, 1);
		System.out.println("조회 1 :"+board.toString());
		
		//검색한 엔티티를 삭제한다
		em.remove(board);
		
		tx.commit();
		//==========================
		
		
		
		
		//영속성에 위배되는 case2
		tx.begin();
		Board board = em.find(Board.class, 1);
		
		board = em.find(Board.class, 1);
		System.out.println("조회 2 :"+board.toString());
		tx.commit();
		
		
		em.close();
		emf.close();
	}*/
	
	//목록검색
	/*
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
	
		
		String jpql ="select title  from Board b order by b.seq desc";
		List<String> boardList = em.createQuery(jpql).getResultList();
		for(String board :boardList) {
			System.out.println("-->"+ board.toString());
		}
		
		//글목록을 검색을 한다.
		//Board class 이다. (Table이 아니다.)
		//변수이다.(seq 컬럼이 아니다. )
		String jpql ="select b from Board b order by b.seq desc";
		List<Board> boardList = em.createQuery(jpql).getResultList();
		for(Board board :boardList) {
			System.out.println("-->"+ board.toString());
		}
		 
		
		em.close();
		emf.close();
	}*/
	/*
	//삭제
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		tx.begin();
		//수정할 게시글을 검색을 한다.
		Board board = em.find(Board.class, 1);
		
		//검색한 엔티티를 삭제한다
		em.remove(board);
		
		tx.commit();
		System.out.println("조회 :"+board.toString());
		em.close();
		emf.close();
	}
	*/
	//수정
	/*
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		tx.begin();
		//수정할 게시글을 검색을 한다.
		Board board = em.find(Board.class, 1);
		
		//검색한 엔티티를 수정한다
		board.setTitle("수정 Title");
		board.setContent("수정 Content");
		
		tx.commit();
		System.out.println("조회 :"+board.toString());
		em.close();
		emf.close();
	}*/
	/*
	//JPA
	////find 상세조회
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		//find(리턴값, pk)
		Board board = em.find(Board.class, 1);
		System.out.println("조회 :"+board.toString());
		em.close();
		emf.close();
	}*/
	
	/*
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		
		//글등록
		tx.begin();
		for (int i = 0; i < 3; i++) {
			Board board = new Board();
			board.setTitle("JPA 제목>>"+i);
			board.setWriter("JPA 작성자>>"+i);
			board.setContent("JPA 내용>>"+i);
			board.setRegDate(new Date());
			board.setCnt(i);
			em.persist(board);
		}
		
		tx.commit();
		
		em.close();
		emf.close();
	}*/

}
