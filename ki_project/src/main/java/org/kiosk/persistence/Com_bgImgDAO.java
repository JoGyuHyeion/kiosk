package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_bgImgVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_bgImgDAO {
	public void create(Com_bgImgVO dto) throws Exception;

	public Com_bgImgVO read(Integer ic_no) throws Exception;

	public void update(Com_bgImgVO dto) throws Exception;

	public void delete(Integer ic_no) throws Exception;

	public List<Com_bgImgVO> listAll() throws Exception;
	
	public List<Com_bgImgVO> jsonList() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_bgImgVO> listPage(int page) throws Exception;

	public List<Com_bgImgVO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	// use for dynamic sql

	public List<Com_bgImgVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
