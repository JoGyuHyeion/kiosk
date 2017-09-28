package org.zerock.service;

import java.util.List;

import org.zerock.domain.Com_staffVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

public interface Com_staffService {

  public void regist(Com_staffVO vo) throws Exception;

  public Com_staffVO read(Integer st_no) throws Exception;

  public void modify(Com_staffVO vo) throws Exception;

  public void remove(Integer st_no) throws Exception;

  public List<Com_staffVO> listAll() throws Exception;

  public List<Com_staffVO> listCriteria(Criteria cri) throws Exception;

  public int listCountCriteria(Criteria cri) throws Exception;

  public List<Com_staffVO> listSearchCriteria(SearchCriteria cri) 
      throws Exception;

  public int listSearchCount(SearchCriteria cri) throws Exception;

}
