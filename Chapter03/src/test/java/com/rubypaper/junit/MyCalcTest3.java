package com.rubypaper.junit;

import junit.framework.TestCase;

public class MyCalcTest3 extends TestCase {
	
	private MyCalc calc;

	protected void setUp() throws Exception {
		// 테스트 데이터 세팅 작업
		System.out.println("---> setUp()");
		calc = new MyCalc(10, 3);
	}

	protected void tearDown() throws Exception {
		// 테스트 이전 상태로 되돌리는 작업 
		System.out.println("---> tearDown()");
		calc = null;
	}

	public void testPlus() {
		System.out.println("===> testPlus()");
		assertEquals(13, calc.plus());
	}

	public void testMinus() {
		System.out.println("===> testMinus()");
		assertEquals(7, calc.minus());
	}

}
