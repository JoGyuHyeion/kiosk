package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Com_boardVO;

public interface Com_boardService {
	 public void regist(Com_boardVO vo) throws Exception;

	  public Com_boardVO read(Integer bbs_no) throws Exception;

	  public void modify(Com_boardVO vo) throws Exception;

	  public void remove(Integer bbs_no) throws Exception;

	  public List<Com_boardVO> listAll() throws Exception;
}
