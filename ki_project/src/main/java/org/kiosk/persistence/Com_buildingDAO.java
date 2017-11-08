package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_buildingVO;

public interface Com_buildingDAO {
	public void create(Com_buildingVO dto) throws Exception;

	public Com_buildingVO read(Integer bu_no) throws Exception;

	public void update(Com_buildingVO dto) throws Exception;

	public void delete(Integer bu_no) throws Exception;

	public List<Com_buildingVO> listAll() throws Exception;
}
