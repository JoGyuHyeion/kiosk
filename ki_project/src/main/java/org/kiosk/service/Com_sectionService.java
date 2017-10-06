package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Com_sectionVO;

public interface Com_sectionService {
	 public void regist(Com_sectionVO vo) throws Exception;

	  public Com_sectionVO read(String section_cd) throws Exception;

	  public void modify(Com_sectionVO vo) throws Exception;

	  public void remove(String section_cd) throws Exception;

	  public List<Com_sectionVO> listAll() throws Exception;
}
