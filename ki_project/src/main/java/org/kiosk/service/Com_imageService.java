package org.kiosk.service;

import java.util.List;
import org.kiosk.domain.Com_imageVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_imageService {
	public void regist(Com_imageVO vo) throws Exception;

	public Com_imageVO read(Integer img_no) throws Exception;

	public void modify(Com_imageVO vo) throws Exception;

	public void remove(Integer img_no) throws Exception;

	public List<Com_imageVO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_imageVO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<Com_imageVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

}
