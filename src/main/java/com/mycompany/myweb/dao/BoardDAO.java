package com.mycompany.myweb.dao;

import java.util.List;

import com.mycompany.myweb.model.BoardVO;

public interface BoardDAO {

	public void write(BoardVO boardVO) throws Exception;

	public List<BoardVO> list() throws Exception;

	public BoardVO read(int bno) throws Exception;

	public void update(BoardVO boardVO) throws Exception;

	// 게시물 삭제
	public void delete(int bno) throws Exception;

}
