package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_sectionVO;

public interface Com_sectionDAO {
	  public void create(Com_sectionVO vo) throws Exception;

	  public Com_sectionVO read(String section_cd) throws Exception;

	  public void update(Com_sectionVO vo) throws Exception;

	  public void delete(String section_cd) throws Exception;

	  public List<Com_sectionVO> listAll() throws Exception;
	  
	  public List<Com_sectionVO> bureauList(String bureau_cd) throws Exception;
	  
	  public int lastInsertSort(String bureau_cd) throws Exception;
	  
	  public String readSectionNm(String section_fullcode) throws Exception;

}
