package org.kiosk.service;

import java.util.List;
import org.kiosk.dto.Com_videoDTO;

public interface JsonvideoService {
	  public void regist(Com_videoDTO dto) throws Exception;

	  public Com_videoDTO read(Integer vi_no) throws Exception;

	  public void modify(Com_videoDTO dto) throws Exception;

	  public void remove(Integer vi_no) throws Exception;
	  
	  public List<Com_videoDTO> listAll() throws Exception;
}
