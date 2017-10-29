package org.kiosk.persistence;

import java.util.List;
<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/persistence/TeamsDAO.java

=======
>>>>>>> 8990e218fa1fb8e7e3d91484a8974a0d83798bc1:ki_project/src/main/java/org/kiosk/persistence/TeamsDAO.java
import org.kiosk.dto.TeamsDTO;

public interface TeamsDAO {
	
//	  public void create(TeamsDTO dto) throws Exception;

//	  public TeamsDTO read(Com_teamVO vo) throws Exception;

//	  public void update(TeamsDTO dto) throws Exception;

//	  public void delete(Integer no) throws Exception;
	  
	  public List<TeamsDTO> list(String section_cd) throws Exception;
}
