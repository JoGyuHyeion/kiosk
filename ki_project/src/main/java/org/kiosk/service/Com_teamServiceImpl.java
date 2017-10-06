package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Com_teamVO;
import org.kiosk.persistence.Com_teamDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_teamServiceImpl implements Com_teamService{

	@Inject
	private Com_teamDAO dao;

	@Override
	public void regist(Com_teamVO vo) throws Exception {
		dao.create(vo);
		
	}

	@Override
	public Com_teamVO read(Integer st_no) throws Exception {
		return dao.read(st_no);
	}

	@Override
	public void modify(Com_teamVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void remove(Integer st_no) throws Exception {
		dao.delete(st_no);
		
	}

	@Override
	public List<Com_teamVO> listAll() throws Exception {
		return dao.listAll();
	}

	
}
