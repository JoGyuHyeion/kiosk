package org.zerock.service;

import java.util.List;

import org.zerock.domain.Com_menuVO;

public interface Com_menuService {
	 public void regist(Com_menuVO vo) throws Exception;

	  public Com_menuVO read(Integer menu_no) throws Exception;

	  public void modify(Com_menuVO vo) throws Exception;

	  public void remove(Integer menu_no) throws Exception;

	  public List<Com_menuVO> listAll() throws Exception;
}
