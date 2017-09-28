package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.Com_boardVO;

public interface Com_boardDAO {
	  public void create(Com_boardVO vo) throws Exception;

	  public Com_boardVO read(Integer bbs_no) throws Exception;

	  public void update(Com_boardVO vo) throws Exception;

	  public void delete(Integer bbs_no) throws Exception;

	  public List<Com_boardVO> listAll() throws Exception;
}
