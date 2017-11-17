package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Com_iconVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_iconService {
	public void regist(Com_iconVO vo) throws Exception;

	public Com_iconVO read(Integer ic_no) throws Exception;

	public void modify(Com_iconVO vo) throws Exception;

	public void remove(Integer ic_no) throws Exception;

	public List<Com_iconVO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_iconVO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<Com_iconVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
