package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.Com_imageVO;

public interface Com_imageDAO {
	  public void create(Com_imageVO vo) throws Exception;

	  public Com_imageVO read(Integer img_no) throws Exception;

	  public void update(Com_imageVO vo) throws Exception;

	  public void delete(Integer img_no) throws Exception;

	  public List<Com_imageVO> listAll() throws Exception;
}
