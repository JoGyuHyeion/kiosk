package org.zerock.service;

import java.util.List;

import org.zerock.dto.JsonGelleryDTO;
import org.zerock.dto.MateDTO;

public interface MateService {

	  public void regist(MateDTO dto) throws Exception;
	  
	  public MateDTO read(Integer no) throws Exception;

	  public void modify(MateDTO dto) throws Exception;

	  public void remove(Integer no) throws Exception;
	  
	  public List<MateDTO> listAll() throws Exception;
}
