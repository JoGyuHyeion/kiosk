package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Com_menuVO;
import org.kiosk.persistence.Com_menuDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_menuServiceImpl implements Com_menuService {

	@Inject
	private Com_menuDAO dao;

	@Override
	public void regist(Com_menuVO vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public Com_menuVO read(Integer menu_no) throws Exception {
		return dao.read(menu_no);
	}

	@Override
	public void modify(Com_menuVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void remove(Integer menu_no) throws Exception {
		dao.delete(menu_no);
	}

	@Override
	public List<Com_menuVO> listAll() throws Exception {
		return dao.listAll();
	}

}
