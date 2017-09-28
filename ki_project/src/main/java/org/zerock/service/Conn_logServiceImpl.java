package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.Conn_logVO;
import org.zerock.persistence.Conn_logDAO;

@Service
public class Conn_logServiceImpl implements Conn_logService {

	@Inject
	private Conn_logDAO dao;

	@Override
	public void regist(Conn_logVO vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public Conn_logVO read(Integer conn_id) throws Exception {
		return dao.read(conn_id);
	}

	@Override
	public void modify(Conn_logVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void remove(Integer conn_id) throws Exception {
		dao.delete(conn_id);

	}

	@Override
	public List<Conn_logVO> listAll() throws Exception {
		return dao.listAll();
	}

}
