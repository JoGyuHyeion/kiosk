package org.kiosk.persistence;

import java.util.List;

import org.kiosk.dto.TeamsDTO;

public interface TeamsDAO {
	
//	  public void create(TeamsDTO dto) throws Exception;

	  public TeamsDTO read(Integer no) throws Exception;

//	  public void update(TeamsDTO dto) throws Exception;

//	  public void delete(Integer no) throws Exception;
	  
//	  public List<TeamsDTO> listAll() throws Exception;
}
