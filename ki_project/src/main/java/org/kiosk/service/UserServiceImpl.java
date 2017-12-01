package org.kiosk.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.SearchCriteria;
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
	public void keepLogin(String id, String sessionId, Date next) throws Exception {

		dao.keepLogin(id, sessionId, next);

	}

	@Override
	public UserVO checkLoginBefore(String value) {

		return dao.checkUserWithSessionKey(value);
	}

	@Override
	public void newUser(UserVO vo) throws Exception {
		dao.newUser(vo);

	}

	@Override
	public void changePassword(LoginDTO dto) throws Exception {
		dao.changePassword(dto);

	}

	@Override
	public UserVO dupCheck(LoginDTO dto) throws Exception {
		return dao.dupCheck(dto);
	}

	@Override
	public UserVO read(String id) throws Exception {
		return dao.read(id);
	}

	@Override
	public void modify(UserVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void remove(String id) throws Exception {
		dao.delete(id);

	}

	@Override
	public List<UserVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<UserVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
}
