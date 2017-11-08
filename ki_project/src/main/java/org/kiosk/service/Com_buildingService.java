package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Com_buildingVO;

public interface Com_buildingService {
	public void regist(Com_buildingVO dto) throws Exception;

	public Com_buildingVO read(Integer bu_no) throws Exception;

	public void modify(Com_buildingVO dto) throws Exception;

	public void remove(Integer bu_no) throws Exception;
	
	public List<Com_buildingVO> listAll() throws Exception;
}
