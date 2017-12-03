package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Com_teamVO;

public interface Com_teamService {
	public void regist(Com_teamVO vo) throws Exception;

	public Com_teamVO read(Com_teamVO vo) throws Exception;

	public void modify(Com_teamVO vo) throws Exception;

	public void remove(Com_teamVO vo) throws Exception;

	public List<Com_teamVO> list(String section_fullcode) throws Exception;
	
	public List<Com_teamVO> jsonList(String bureau_cd) throws Exception;
	
	public int lastInsertSort(String section_cd) throws Exception;

	public Com_teamVO readTeamCd(String section_cd,String team_nm) throws Exception;
		
}
