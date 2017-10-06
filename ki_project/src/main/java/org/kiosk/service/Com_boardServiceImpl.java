package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Com_boardVO;
import org.kiosk.persistence.Com_boardDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_boardServiceImpl implements Com_boardService{

	@Inject
	private Com_boardDAO dao;

	@Override
	public void regist(Com_boardVO vo) throws Exception {
		dao.create(vo);
		
	}

	@Override
	public Com_boardVO read(Integer bbs_no) throws Exception {
		return dao.read(bbs_no);
	}

	@Override
	public void modify(Com_boardVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void remove(Integer bbs_no) throws Exception {
		dao.delete(bbs_no);
		
	}

	@Override
	public List<Com_boardVO> listAll() throws Exception {
		return dao.listAll();
	}

}
