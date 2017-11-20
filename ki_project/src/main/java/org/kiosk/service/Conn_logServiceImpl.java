package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Conn_logVO;
import org.kiosk.persistence.Conn_logDAO;
import org.kiosk.persistence.Vol_checkDAO;
import org.springframework.stereotype.Service;

@Service
public class Conn_logServiceImpl implements Conn_logService {

	@Inject
	private Conn_logDAO dao;
	@Inject
	private Vol_checkDAO vol_dao;

	@Override
	public void regist(Conn_logVO vo) throws Exception {
		dao.create(vo);
		vol_dao.update("log");
	}

	@Override
	public Conn_logVO read(Integer conn_id) throws Exception {
		return dao.read(conn_id);
	}

	@Override
	public void modify(Conn_logVO vo) throws Exception {
		dao.update(vo);
		vol_dao.update("log");
	}

	@Override
	public void remove(Integer conn_id) throws Exception {
		dao.delete(conn_id);
		vol_dao.update("log");
	}

	@Override
	public List<Conn_logVO> listAll() throws Exception {
		return dao.listAll();
	}

}
