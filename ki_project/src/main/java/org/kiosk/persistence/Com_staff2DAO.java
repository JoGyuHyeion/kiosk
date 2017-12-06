package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_staff2VO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_staff2DAO {
	public void create(Com_staff2VO vo) throws Exception;

	public Com_staff2VO read(Integer st_no) throws Exception;

	public void update(Com_staff2VO vo) throws Exception;

	public void delete(Integer st_no) throws Exception;

	public List<Com_staff2VO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_staff2VO> listPage(int page) throws Exception;

	public List<Com_staff2VO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	// use for dynamic sql

	public List<Com_staff2VO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	//
	public int createSortNo(Com_staff2VO vo) throws Exception;

	public void sortupdate(Com_staff2VO vo) throws Exception;
	
	public List<Com_staff2VO> teamListSort(Com_staff2VO vo) throws Exception;

	
}
