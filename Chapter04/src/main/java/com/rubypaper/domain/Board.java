package com.rubypaper.domain;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Transient;
import lombok.Data;

//@Getter
//@Setter 
//.. 생성자등 포함
@Data
@Entity				 	 //필수
//@SequenceGenerator(name = "BOARD_SEQ_GENGERATOR", 
//					sequenceName = "BOARD_SEQUENCE",
//					initialValue = 1, 
//					allocationSize = 1)
//@TableGenerator(name = "BOARD_SEQ_GENGERATOR", table ="SEQUENCE_TABLE",initialValue = 0,allocationSize = 1)
@Table(name = "BOARD")	//옵션 @Table이름과 class Board이 동일하면 생략가능
public class Board {
	// BOARD 테이블의 컬럼과 매핑되는 private 변수를 선언한다.
	@Id					//필수(PK 컬럼과 매핑된 변수 지정)
	//@GeneratedValue(strategy = GenerationType.AUTO)											//1. 일반적인 전략 
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENGERATOR")		//2. 일반적인 전략
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENGERATOR")		//2. 일반적인 전략
	@GeneratedValue
	private int seq;
	private String title;

	@Column(unique = true)
	private String writer;
	
	@Column(name = "REG_DATA")
	private String content;
	private Date regDate;
	private int cnt;
	
	
}

/*
 * 
	@Transient
	private String seearchConditing;
 */
 
