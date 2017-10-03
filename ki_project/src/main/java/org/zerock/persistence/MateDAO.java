package org.zerock.persistence;

import java.util.List;

import org.zerock.dto.JsonGelleryDTO;
import org.zerock.dto.MateDTO;

public interface MateDAO {

	  public void create(MateDTO dto) throws Exception;
	  
	  public MateDTO read(Integer no) throws Exception;

	  public void update(MateDTO dto) throws Exception;

	  public void delete(Integer no) throws Exception;
	  
	  public List<MateDTO> listAll() throws Exception;
}
