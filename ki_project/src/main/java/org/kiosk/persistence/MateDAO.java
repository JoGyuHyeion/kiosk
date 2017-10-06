package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_staffVO;
import org.kiosk.dto.MateDTO;

public interface MateDAO {

	  //public void create(MateDTO dto) throws Exception;
	  
	  public MateDTO read(Integer no) throws Exception;

	  public void update(MateDTO dto) throws Exception;

	  public void delete(Integer no) throws Exception;
	  
	  public List<MateDTO> listAll(Com_staffVO vo) throws Exception;
}
