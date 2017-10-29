package org.kiosk.service;

import java.util.List;
<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/service/MateService.java

import org.kiosk.dto.JsonGelleryDTO;
import org.kiosk.dto.MateDTO;
=======
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
>>>>>>> 8990e218fa1fb8e7e3d91484a8974a0d83798bc1:ki_project/src/main/java/org/kiosk/service/MateService.java

public interface MateService {

//	  public void regist(MateDTO dto) throws Exception;
	  
	  public MateDTO read(Integer no) throws Exception;

	  public void modify(MateDTO dto) throws Exception;

	  public void remove(Integer no) throws Exception;
	  
	  public List<MateDTO> list(TeamsDTO dto) throws Exception;
}
