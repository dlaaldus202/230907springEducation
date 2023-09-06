package com.rubypaper.domain;

import java.util.Date;
import java.util.Objects;

import lombok.Data;

//@Getter
//@Setter 
//.. 생성자등 포함
@Data
public class BoardVO {
	// BOARD 테이블의 컬럼과 매핑되는 private 변수를 선언한다.
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
}
