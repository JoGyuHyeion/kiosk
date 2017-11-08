package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Com_bgImgVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_bgImgService {
	public void regist(Com_bgImgVO dto) throws Exception;

	public Com_bgImgVO read(Integer ic_no) throws Exception;

	public void modify(Com_bgImgVO dto) throws Exception;

	public void remove(Integer ic_no) throws Exception;

	public List<Com_bgImgVO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_bgImgVO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<Com_bgImgVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
