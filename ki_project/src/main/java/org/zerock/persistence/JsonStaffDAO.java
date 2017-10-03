package org.zerock.persistence;

import java.util.List;

import org.zerock.dto.JsonStaffDTO;

public interface JsonStaffDAO {

	  public void create(JsonStaffDTO dto) throws Exception;

	  public JsonStaffDTO read(Integer no) throws Exception;

	  public void update(JsonStaffDTO dto) throws Exception;

	  public void delete(Integer no) throws Exception;
	  
	  public List<JsonStaffDTO> listAll() throws Exception;
}
