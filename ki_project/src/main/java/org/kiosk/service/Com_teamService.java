package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Com_teamVO;

public interface Com_teamService {
	 public void regist(Com_teamVO vo) throws Exception;

	  public Com_teamVO read(Integer st_no) throws Exception;

	  public void modify(Com_teamVO vo) throws Exception;

	  public void remove(Integer st_no) throws Exception;

	  public List<Com_teamVO> listAll() throws Exception;
}
