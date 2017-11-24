package org.kiosk.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.UserVO;
import org.kiosk.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {

		return session.selectOne(namespace + ".login", dto);
	}

	@Override
	public void keepLogin(String id, String sessionId, Date next) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);

		session.update(namespace + ".keepLogin", paramMap);

	}

	@Override
	public UserVO checkUserWithSessionKey(String value) {

		return session.selectOne(namespace + ".checkUserWithSessionKey", value);
	}

	@Override
	public void newUser(UserVO vo) throws Exception {
		session.insert(namespace + ".newUser", vo);

	}

	@Override
	public void changePassword(LoginDTO dto) throws Exception {
		session.update(namespace + ".changePassword", dto);

	}

	@Override
	public UserVO dupCheck(LoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".dupCheck", dto);
	}

}
