package org.kiosk.persistence;

import java.util.List;
<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/persistence/MateDAO.java

import org.kiosk.dto.JsonGelleryDTO;
import org.kiosk.dto.MateDTO;
=======
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
>>>>>>> 8990e218fa1fb8e7e3d91484a8974a0d83798bc1:ki_project/src/main/java/org/kiosk/persistence/MateDAO.java

public interface MateDAO {

	  //public void create(MateDTO dto) throws Exception;
	  
	  public MateDTO read(Integer no) throws Exception;

	  public void update(MateDTO dto) throws Exception;

	  public void delete(Integer no) throws Exception;
	  
	  public List<MateDTO> list(TeamsDTO dto) throws Exception;
}
