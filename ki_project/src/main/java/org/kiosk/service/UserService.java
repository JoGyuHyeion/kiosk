package org.kiosk.service;

import java.util.Date;

import org.kiosk.domain.UserVO;
import org.kiosk.dto.LoginDTO;

public interface UserService {

	public UserVO login(LoginDTO dto) throws Exception;

	public void keepLogin(String id, String sessionId, Date next) throws Exception;

	public UserVO checkLoginBefore(String value);
}
