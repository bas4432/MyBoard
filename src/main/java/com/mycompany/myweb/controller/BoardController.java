package com.mycompany.myweb.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.model.BoardVO;
import com.mycompany.myweb.service.BoardSerivce;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardSerivce boardSerivce;
	
	
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public String writeView() throws Exception{
			logger.info("writeView");
			
			return "board/writeView";
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception{
		logger.info("write");
		
		boardSerivce.write(boardVO);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
			logger.info("list");
			
			model.addAttribute("list" , boardSerivce.list());
			
			
			return "board/list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(BoardVO boardVO, Model model) throws Exception{
			logger.info("read");
			
			logger.info("boardVO.getBno()::" + boardVO.getBno());
			model.addAttribute("read", boardSerivce.read(boardVO.getBno()));
			
			logger.info("read::" + boardSerivce.read(boardVO.getBno()));
			
			return "board/read";
	}
	
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model) throws Exception{
		logger.info("updateView");
		
		model.addAttribute("update", boardSerivce.read(boardVO.getBno()));
		
		return "board/updateView";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(BoardVO boardVO) throws Exception{
			logger.info("update");
			
			boardSerivce.update(boardVO);
			
			return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception{
		logger.info("delete");
		
		boardSerivce.delete(boardVO.getBno());
		
		return "redirect:/board/list";
	}
	
	
	
	
}
