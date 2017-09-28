package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.Conn_logVO;

public interface Conn_logDAO {
	
	  public void create(Conn_logVO vo) throws Exception;

	  public Conn_logVO read(Integer conn_id) throws Exception;

	  public void update(Conn_logVO vo) throws Exception;

	  public void delete(Integer conn_id) throws Exception;

	  public List<Conn_logVO> listAll() throws Exception;


}
