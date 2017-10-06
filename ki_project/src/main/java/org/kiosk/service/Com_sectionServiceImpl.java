package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Com_sectionVO;
import org.kiosk.persistence.Com_sectionDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_sectionServiceImpl implements Com_sectionService {

	@Inject
	private Com_sectionDAO dao;

	@Override
	public void regist(Com_sectionVO vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public Com_sectionVO read(String section_cd) throws Exception {
		return dao.read(section_cd);
	}

	@Override
	public void modify(Com_sectionVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void remove(String section_cd) throws Exception {
		dao.delete(section_cd);

	}

	@Override
	public List<Com_sectionVO> listAll() throws Exception {
		return dao.listAll();
	}

}
