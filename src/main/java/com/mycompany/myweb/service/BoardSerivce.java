package com.mycompany.myweb.service;

import java.util.List;

import com.mycompany.myweb.model.BoardVO;

public interface BoardSerivce {
	
	public void write(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> list() throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public void update(BoardVO boardVO) throws Exception;
	
	public void delete(int bno) throws Exception;

}
