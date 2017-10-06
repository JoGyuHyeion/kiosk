package org.kiosk.service;

import java.util.List;

<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/service/MateService.java
import org.kiosk.dto.JsonGelleryDTO;
=======
import org.kiosk.domain.Com_staffVO;
>>>>>>> c718f6c0b276656d7d57c48609db55c599051672:ki_project/src/main/java/org/kiosk/service/MateService.java
import org.kiosk.dto.MateDTO;

public interface MateService {

//	  public void regist(MateDTO dto) throws Exception;
	  
	  public MateDTO read(Integer no) throws Exception;

	  public void modify(MateDTO dto) throws Exception;

	  public void remove(Integer no) throws Exception;
	  
	  public List<MateDTO> listAll(Com_staffVO vo) throws Exception;
}
