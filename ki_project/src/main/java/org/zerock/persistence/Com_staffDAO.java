<<<<<<< HEAD
package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.Com_staffVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

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
=======
package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.Com_staffVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

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
>>>>>>> ab9babf5047782ebfc1d6dbed110703b09390fc2
