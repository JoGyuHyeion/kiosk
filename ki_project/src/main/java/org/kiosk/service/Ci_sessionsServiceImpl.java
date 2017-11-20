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
	@Inject
	private Vol_checkService volService;
	
	private static final String VERSION="session";

	@Override
	public void regist(Ci_sessionsVO vo) throws Exception {
		dao.create(vo);
		volService.update(VERSION);
		
	}

	@Override
	public Ci_sessionsVO read(int timestamp) throws Exception {
		return dao.read(timestamp);
	}

	@Override
	public void modify(Ci_sessionsVO vo) throws Exception {
		dao.update(vo);
		volService.update(VERSION);	
	}

	@Override
	public void remove(int timestamp) throws Exception {
		dao.delete(timestamp);
		volService.update(VERSION);
	}

	@Override
	public List<Ci_sessionsVO> listAll() throws Exception {
		return dao.listAll();
	}

}
