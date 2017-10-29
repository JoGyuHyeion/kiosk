package org.kiosk.service;

import java.util.List;
import org.kiosk.dto.Com_buildingDTO;

public interface JsonbuildingService {
	public void regist(Com_buildingDTO dto) throws Exception;

	public Com_buildingDTO read(Integer bu_no) throws Exception;

	public void modify(Com_buildingDTO dto) throws Exception;

	public void remove(Integer bu_no) throws Exception;
	
	public List<Com_buildingDTO> listAll() throws Exception;
}
