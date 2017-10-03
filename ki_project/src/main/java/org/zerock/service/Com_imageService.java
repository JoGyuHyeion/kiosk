package org.zerock.service;

import java.util.List;

import org.zerock.domain.Com_imageVO;

public interface Com_imageService {
	 public void regist(Com_imageVO vo) throws Exception;

	  public Com_imageVO read(Integer img_no) throws Exception;

	  public void modify(Com_imageVO vo) throws Exception;

	  public void remove(Integer img_no) throws Exception;

	  public List<Com_imageVO> listAll() throws Exception;
}
