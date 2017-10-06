package org.kiosk.persistence;

import java.util.List;

import org.kiosk.domain.Ci_sessionsVO;

public interface Ci_sessionsDAO {
	  public void create(Ci_sessionsVO vo) throws Exception;

	  public Ci_sessionsVO read(int timestamp) throws Exception;

	  public void update(Ci_sessionsVO vo) throws Exception;

	  public void delete(int timestamp) throws Exception;

	  public List<Ci_sessionsVO> listAll() throws Exception;
}
