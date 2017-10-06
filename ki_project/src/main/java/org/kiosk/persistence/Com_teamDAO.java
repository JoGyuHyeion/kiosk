package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_teamVO;

public interface Com_teamDAO {
	  public void create(Com_teamVO vo) throws Exception;

	  public Com_teamVO read(Integer st_no) throws Exception;

	  public void update(Com_teamVO vo) throws Exception;

	  public void delete(Integer st_no) throws Exception;

	  public List<Com_teamVO> listAll() throws Exception;
}
