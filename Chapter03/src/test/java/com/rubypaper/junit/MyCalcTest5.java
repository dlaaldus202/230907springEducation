package com.rubypaper.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCalcTest5 {
	
	private MyCalc calc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("---> setUpBeforeClass()");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("---> tearDownAfterClass()");
	}

	@BeforeEach
	void init() throws Exception {
		System.out.println("---> init()");
		calc = new MyCalc(10, 3);
	}

	@AfterEach
	void destroy() throws Exception {
		System.out.println("---> destroy()");
		calc = null;
	}

	@Test
	void 플러스() {
		System.out.println("===> 플러스()");
		assertEquals(13, calc.plus());
	}

	@Test
	void 마이너스() {
		System.out.println("===> 마이너스()");
		assertEquals(7, calc.minus());
	}

}
