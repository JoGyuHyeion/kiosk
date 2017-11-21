package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.domain.Conn_logVO;
import org.kiosk.persistence.Conn_logDAO;
import org.springframework.stereotype.Service;

@Service
public class Conn_logServiceImpl implements Conn_logService {

	@Inject
	private Conn_logDAO dao;
	@Inject
	private Vol_checkService volService;
	
	private static final String VERSION="log";

	@Override
	public void regist(Conn_logVO vo) throws Exception {
		dao.create(vo);
		volService.update(VERSION);
	}

	@Override
	public Conn_logVO read(Integer conn_id) throws Exception {
		return dao.read(conn_id);
	}

	@Override
	public void modify(Conn_logVO vo) throws Exception {
		dao.update(vo);
		volService.update(VERSION);
	}

	@Override
	public void remove(Integer conn_id) throws Exception {
		dao.delete(conn_id);
		volService.update(VERSION);
	}

	@Override
	public List<Conn_logVO> listAll() throws Exception {
		return dao.listAll();
	}

}
