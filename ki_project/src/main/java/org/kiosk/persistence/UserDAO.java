package org.kiosk.persistence;

import java.util.Date;

import org.kiosk.domain.UserVO;
import org.kiosk.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto)throws Exception;

  public void keepLogin(String id, String sessionId, Date next);
  
  public UserVO checkUserWithSessionKey(String value);	
}



