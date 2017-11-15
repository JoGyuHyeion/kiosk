package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_iconVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_iconDAO {
	public void create(Com_iconVO vo) throws Exception;

	public Com_iconVO read(Integer ic_no) throws Exception;

	public void update(Com_iconVO vo) throws Exception;

	public void delete(Integer ic_no) throws Exception;

	public List<Com_iconVO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_iconVO> listPage(int page) throws Exception;

	public List<Com_iconVO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	// use for dynamic sql

	public List<Com_iconVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

}
