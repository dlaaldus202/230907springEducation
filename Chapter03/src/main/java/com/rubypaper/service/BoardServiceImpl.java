package com.rubypaper.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired 
	private BoardDAO boardDAO;
	
	@Override
	public String hello(String name) {
		return "hello : "+name;
	}
	
	@Override
	public Map<String, Object> getBoard(int seq) {
		return boardDAO.getBoard(seq);
	}
	
	@Override
	public List<Map<String, Object>> getBoardList() {
		return boardDAO.getBoardList();
	}
	
	
}
