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
public class Board {
	// BOARD 테이블의 컬럼과 매핑되는 private 변수를 선언한다.
	@Id					//필수(PK 컬럼과 매핑된 변수 지정)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	
}

/*
 * 
	@Transient
	private String seearchConditing;
 */
 
