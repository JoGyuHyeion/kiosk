package org.kiosk.service;

import java.util.Date;

import javax.inject.Inject;

import org.kiosk.domain.UserVO;
import org.kiosk.dto.LoginDTO;
import org.kiosk.persistence.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Inject
  private UserDAO dao;

  @Override
  public UserVO login(LoginDTO dto) throws Exception {
    return dao.login(dto);
  }
  
  @Override
  public void keepLogin(String id, String sessionId, Date next)
      throws Exception {
    
    dao.keepLogin(id, sessionId, next);
    
  }

  @Override
  public UserVO checkLoginBefore(String value) {
    
    return dao.checkUserWithSessionKey(value);
  }
}
