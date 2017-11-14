package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_boardVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_boardDAO {
	public void create(Com_boardVO vo) throws Exception;

	public Com_boardVO read(Integer bbs_no) throws Exception;

	public void update(Com_boardVO vo) throws Exception;

	public void delete(Integer bbs_no) throws Exception;

	public List<Com_boardVO> listAll() throws Exception;

	public List<Com_boardVO> listPage(int page) throws Exception;

	public List<Com_boardVO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	// use for dynamic sql

	public List<Com_boardVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}