package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Conn_logVO;

public interface Conn_logService {
	 public void regist(Conn_logVO vo) throws Exception;

	  public Conn_logVO read(Integer conn_id) throws Exception;

	  public void modify(Conn_logVO vo) throws Exception;

	  public void remove(Integer conn_id) throws Exception;

	  public List<Conn_logVO> listAll() throws Exception;
}
