package org.kiosk.service;

<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/service/TeamsService.java
import java.util.List;

=======
import org.kiosk.domain.Com_teamVO;
>>>>>>> c718f6c0b276656d7d57c48609db55c599051672:ki_project/src/main/java/org/kiosk/service/TeamsService.java
import org.kiosk.dto.TeamsDTO;

public interface TeamsService {
	
//	  public void create(TeamsDTO dto) throws Exception;

	  public TeamsDTO read(Com_teamVO vo) throws Exception;

//	  public void update(TeamsDTO dto) throws Exception;

//	  public void delete(Integer no) throws Exception;
	  
//	  public List<TeamsDTO> listAll() throws Exception;
}
