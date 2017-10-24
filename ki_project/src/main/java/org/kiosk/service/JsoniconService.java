package org.kiosk.service;

import java.util.List;
import org.kiosk.dto.Com_iconDTO;

public interface JsoniconService {
	  public void regist(Com_iconDTO dto) throws Exception;

	  public Com_iconDTO read(Integer ic_no) throws Exception;

	  public void modify(Com_iconDTO dto) throws Exception;

	  public void remove(Integer ic_no) throws Exception;
	  
	  public List<Com_iconDTO> listAll() throws Exception;
}
