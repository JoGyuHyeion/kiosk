package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Com_staffVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;

public interface Com_staffDAO {

  public void create(Com_staffVO vo) throws Exception;

  public Com_staffVO read(Integer st_no) throws Exception;

  public void update(Com_staffVO vo) throws Exception;

  public void delete(Integer st_no) throws Exception;

  public List<Com_staffVO> listAll() throws Exception;

  public List<Com_staffVO> listPage(int page) throws Exception;

  public List<Com_staffVO> listCriteria(Criteria cri) throws Exception;

  public int countPaging(Criteria cri) throws Exception;
  
  //use for dynamic sql
  
  public List<Com_staffVO> listSearch(SearchCriteria cri)throws Exception;
  
  public int listSearchCount(SearchCriteria cri)throws Exception;

}

