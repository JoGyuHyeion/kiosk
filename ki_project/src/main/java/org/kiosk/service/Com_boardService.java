package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Com_boardVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_boardService {
	 public void regist(Com_boardVO vo) throws Exception;

	  public Com_boardVO read(Integer bbs_no) throws Exception;

	  public void modify(Com_boardVO vo) throws Exception;

	  public void remove(Integer bbs_no) throws Exception;

	  public List<Com_boardVO> listAll() throws Exception;
<<<<<<< HEAD

=======
	  
>>>>>>> 8990e218fa1fb8e7e3d91484a8974a0d83798bc1
	  public List<Com_boardVO> listCriteria(Criteria cri) throws Exception;

	  public int listCountCriteria(Criteria cri) throws Exception;

	  public List<Com_boardVO> listSearchCriteria(SearchCriteria cri) 
	      throws Exception;

	  public int listSearchCount(SearchCriteria cri) throws Exception;
<<<<<<< HEAD


=======
>>>>>>> 8990e218fa1fb8e7e3d91484a8974a0d83798bc1
}
