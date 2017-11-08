package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Com_videoVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_videoService {
	public void regist(Com_videoVO dto) throws Exception;

	public Com_videoVO read(Integer vi_no) throws Exception;

	public void modify(Com_videoVO dto) throws Exception;

	public void remove(Integer vi_no) throws Exception;

	public List<Com_videoVO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_videoVO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<Com_videoVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
