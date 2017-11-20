package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Com_sectionVO;
import org.kiosk.persistence.Com_sectionDAO;
import org.kiosk.persistence.Vol_checkDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_sectionServiceImpl implements Com_sectionService {

	@Inject
	private Com_sectionDAO dao;
	@Inject
	private Vol_checkDAO vol_dao;

	@Override
	public void regist(Com_sectionVO vo) throws Exception {
		dao.create(vo);
		vol_dao.update("section");
	}

	@Override
	public Com_sectionVO read(String section_cd) throws Exception {
		return dao.read(section_cd);
	}

	@Override
	public void modify(Com_sectionVO vo) throws Exception {
		dao.update(vo);
		vol_dao.update("section");
	}

	@Override
	public void remove(String section_cd) throws Exception {
		dao.delete(section_cd);
		vol_dao.update("section");
	}

	@Override
	public List<Com_sectionVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<Com_sectionVO> bureauList(String bureau_cd) throws Exception {
		return dao.bureauList(bureau_cd);
	}

}
