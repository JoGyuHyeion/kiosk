package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.Ci_sessionsVO;

public interface Ci_sessionsDAO {
	  public void create(Ci_sessionsVO vo) throws Exception;

	  public Ci_sessionsVO read(String timestamp) throws Exception;

	  public void update(Ci_sessionsVO vo) throws Exception;

	  public void delete(String timestamp) throws Exception;

	  public List<Ci_sessionsVO> listAll() throws Exception;
}
