package org.zerock.service;

import java.util.List;

import org.zerock.dto.JsonGelleryDTO;

public interface JsonGelleryService {
	
	  public void regist(JsonGelleryDTO dto) throws Exception;

	  public JsonGelleryDTO read(Integer no) throws Exception;

	  public void modify(JsonGelleryDTO dto) throws Exception;

	  public void remove(Integer no) throws Exception;
	  
	  public List<JsonGelleryDTO> listAll(String section_cd) throws Exception;
	  
	  
}
