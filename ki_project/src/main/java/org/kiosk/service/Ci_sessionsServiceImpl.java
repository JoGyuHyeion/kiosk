package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Ci_sessionsVO;
import org.kiosk.persistence.Ci_sessionsDAO;
import org.springframework.stereotype.Service;

@Service
public class Ci_sessionsServiceImpl implements Ci_sessionsService{

	@Inject
	private Ci_sessionsDAO dao;

	@Override
	public void regist(Ci_sessionsVO vo) throws Exception {
		dao.create(vo);
		
	}

	@Override
	public Ci_sessionsVO read(int timestamp) throws Exception {
		return dao.read(timestamp);
	}

	@Override
	public void modify(Ci_sessionsVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void remove(int timestamp) throws Exception {
		dao.delete(timestamp);
		
	}

	@Override
	public List<Ci_sessionsVO> listAll() throws Exception {
		return dao.listAll();
	}

}
