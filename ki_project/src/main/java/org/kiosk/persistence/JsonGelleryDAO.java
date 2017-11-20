package org.kiosk.persistence;

import java.util.List;

import org.kiosk.dto.JsonGelleryDTO;

public interface JsonGelleryDAO {
	
	  public void create(JsonGelleryDTO dto) throws Exception;

	  public JsonGelleryDTO read(Integer no) throws Exception;

	  public void update(JsonGelleryDTO dto) throws Exception;

	  public void delete(Integer no) throws Exception;
	  
	  public List<JsonGelleryDTO> listAll(String section_cd) throws Exception;
}