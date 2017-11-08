package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_videoVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_videoDAO {
	public void create(Com_videoVO dto) throws Exception;

	public Com_videoVO read(Integer vi_no) throws Exception;

	public void update(Com_videoVO dto) throws Exception;

	public void delete(Integer vi_no) throws Exception;

	public List<Com_videoVO> listAll() throws Exception;
	
	public int lastInsertID() throws Exception;

	public List<Com_videoVO> listPage(int page) throws Exception;

	public List<Com_videoVO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	// use for dynamic sql

	public List<Com_videoVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
