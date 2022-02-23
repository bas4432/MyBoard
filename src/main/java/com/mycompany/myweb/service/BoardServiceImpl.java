package com.mycompany.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.myweb.controller.BoardController;
import com.mycompany.myweb.dao.BoardDAO;
import com.mycompany.myweb.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardSerivce{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	
	@Inject
	private BoardDAO boardDAO;

	@Override
	public void write(BoardVO boardVO) throws Exception {
		boardDAO.write(boardVO);
		
	}

	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.list();
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		
		logger.info("read¡¯¿‘ ¿¸:" + bno);
		return boardDAO.read(bno);
		
	
		
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {

              boardDAO.update(boardVO);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		boardDAO.delete(bno);
		
	}

	

}
