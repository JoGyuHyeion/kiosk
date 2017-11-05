package org.kiosk.persistence;

import java.util.List;
import org.kiosk.domain.Com_imageVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_imageDAO {
	public void create(Com_imageVO vo) throws Exception;

	public Com_imageVO read(Integer img_no) throws Exception;

	public void update(Com_imageVO vo) throws Exception;

	public void delete(Integer img_no) throws Exception;

	public List<Com_imageVO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_imageVO> listPage(int page) throws Exception;

	public List<Com_imageVO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	// use for dynamic sql

	public List<Com_imageVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
