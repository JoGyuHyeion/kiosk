package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.Com_teamVO;
import org.zerock.persistence.Com_teamDAO;

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
		return null;
	}

	@Override
	public void modify(Com_teamVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void remove(Integer st_no) throws Exception {
		//dao.delete(st_no);
		
	}

	@Override
	public List<Com_teamVO> listAll() throws Exception {
		return dao.listAll();
	}

	
}
