package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Com_bureauVO;
import org.kiosk.persistence.Com_bureauDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_bureauServiceImpl implements Com_bureauService {

	@Inject
	private Com_bureauDAO dao;

	@Override
	public void regist(Com_bureauVO vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public Com_bureauVO read(String bureau_cd) throws Exception {
		return dao.read(bureau_cd);
	}

	@Override
	public void modify(Com_bureauVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void remove(String bureau_cd) throws Exception {
		dao.delete(bureau_cd);
	}

	@Override
	public List<Com_bureauVO> listAll() throws Exception {
		return dao.listAll();
	}

}
