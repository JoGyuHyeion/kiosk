package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.BuildingVO;

public interface BuildingService {
	public void regist(BuildingVO dto) throws Exception;

	public BuildingVO read(Integer bu_no) throws Exception;

	public void modify(BuildingVO dto) throws Exception;

	public void remove(Integer bu_no) throws Exception;

	public List<BuildingVO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

}
