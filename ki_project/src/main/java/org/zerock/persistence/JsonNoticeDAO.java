package org.zerock.persistence;

import java.util.List;

import org.zerock.dto.JsonGelleryDTO;
import org.zerock.dto.JsonNoticeDTO;

public interface JsonNoticeDAO {
	
	  public void create(JsonNoticeDTO dto) throws Exception;

	  public JsonNoticeDTO read(Integer no) throws Exception;

	  public void update(JsonNoticeDTO dto) throws Exception;

	  public void delete(Integer no) throws Exception;
	  
	  public List<JsonNoticeDTO> listAll() throws Exception;
}
