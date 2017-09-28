package org.zerock.service;

import java.util.List;

import org.zerock.domain.Ci_sessionsVO;

public interface Ci_sessionsService {
	 public void regist(Ci_sessionsVO vo) throws Exception;

	  public Ci_sessionsVO read(String timestamp) throws Exception;

	  public void modify(Ci_sessionsVO vo) throws Exception;

	  public void remove(String timestamp) throws Exception;

	  public List<Ci_sessionsVO> listAll() throws Exception;
}
