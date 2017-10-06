package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.DbTestVO;
import org.kiosk.persistence.DbTestDAO;
import org.springframework.stereotype.Service;

@Service
public class DbTestServiceImpl implements DbTestService {

	@Inject
	private DbTestDAO dao;

	@Override
	public void regist(DbTestVO vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public DbTestVO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void modify(DbTestVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void remove(Integer no) throws Exception {
		dao.delete(no);

	}

	@Override
	public List<DbTestVO> listAll() throws Exception {
		return dao.listAll();
	}

}
