package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_teamVO;

public interface Com_teamDAO {
	public void create(Com_teamVO vo) throws Exception;

	public Com_teamVO read(Com_teamVO vo) throws Exception;

	public void update(Com_teamVO vo) throws Exception;

	public void delete(Com_teamVO vo) throws Exception;

	public List<Com_teamVO> listAll(String section_cd) throws Exception;
	
	public List<Com_teamVO> superListAll() throws Exception;
	
	public List<Com_teamVO> jsonList(String bureau_cd) throws Exception;

}
