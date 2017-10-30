package org.kiosk.service;

import java.util.List;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;

public interface MateService {

//	  public void regist(MateDTO dto) throws Exception;
	  
	  public MateDTO read(Integer no) throws Exception;

	  public void modify(MateDTO dto) throws Exception;

	  public void remove(Integer no) throws Exception;
	  
	  public List<MateDTO> list(TeamsDTO dto) throws Exception;
}