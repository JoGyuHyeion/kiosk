package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Ci_sessionsVO;
import org.kiosk.persistence.Ci_sessionsDAO;
import org.kiosk.persistence.Vol_checkDAO;
import org.springframework.stereotype.Service;

@Service
public class Ci_sessionsServiceImpl implements Ci_sessionsService{

	@Inject
	private Ci_sessionsDAO dao;
	@Inject
	private Vol_checkDAO vol_dao;

	@Override
	public void regist(Ci_sessionsVO vo) throws Exception {
		dao.create(vo);
		vol_dao.update("session");
		
	}

	@Override
	public Ci_sessionsVO read(int timestamp) throws Exception {
		return dao.read(timestamp);
	}

	@Override
	public void modify(Ci_sessionsVO vo) throws Exception {
		dao.update(vo);
		vol_dao.update("session");	
	}

	@Override
	public void remove(int timestamp) throws Exception {
		dao.delete(timestamp);
		vol_dao.update("session");
	}

	@Override
	public List<Ci_sessionsVO> listAll() throws Exception {
		return dao.listAll();
	}

}
