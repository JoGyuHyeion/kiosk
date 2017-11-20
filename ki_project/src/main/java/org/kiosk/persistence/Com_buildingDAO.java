package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_buildingVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_buildingDAO {
	public void create(Com_buildingVO dto) throws Exception;

	public Com_buildingVO read(Integer bu_no) throws Exception;

	public void update(Com_buildingVO dto) throws Exception;

	public void delete(Integer bu_no) throws Exception;

	public List<Com_buildingVO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_buildingVO> listPage(int page) throws Exception;

	public List<Com_buildingVO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	// use for dynamic sql

	public List<Com_buildingVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
