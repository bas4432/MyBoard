package com.mycompany.myweb.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.myweb.model.BoardVO;
import com.mycompany.myweb.service.BoardServiceImpl;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	/* private static final String NAMESPACE = "b"; */
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	
	
	@Inject
	private SqlSession sqlSession; 

	@Override
	public void write(BoardVO boardVO) throws Exception {
		
		sqlSession.insert("boardMapper.insert",boardVO);
	}

	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.list");
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		
		logger.info("read DAO ¡¯¿‘¿¸:" + bno);
		
		
          
		return sqlSession.selectOne("boardMapper.read" , bno);
 
		
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		
		sqlSession.update("boardMapper.update" , boardVO);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("boardMapper.delete" , bno);
		
	}

}
