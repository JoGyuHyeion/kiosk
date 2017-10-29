package org.kiosk.service;

import java.util.List;

<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/service/JsonNoticeService.java
import org.kiosk.dto.JsonGelleryDTO;
=======
>>>>>>> 8990e218fa1fb8e7e3d91484a8974a0d83798bc1:ki_project/src/main/java/org/kiosk/service/JsonNoticeService.java
import org.kiosk.dto.JsonNoticeDTO;

public interface JsonNoticeService {
	
	 // public void regist(JsonNoticeDTO dto) throws Exception;

	  public JsonNoticeDTO read(Integer no) throws Exception;

	  public void modify(JsonNoticeDTO dto) throws Exception;

	  public void remove(Integer no) throws Exception;
	  
	  public List<JsonNoticeDTO> listAll(String section_cd) throws Exception;
}
