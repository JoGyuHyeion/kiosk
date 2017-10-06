package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_menuVO;

public interface Com_menuDAO {
	  public void create(Com_menuVO vo) throws Exception;

	  public Com_menuVO read(Integer menu_no) throws Exception;

	  public void update(Com_menuVO vo) throws Exception;

	  public void delete(Integer menu_no) throws Exception;

	  public List<Com_menuVO> listAll() throws Exception;
}
