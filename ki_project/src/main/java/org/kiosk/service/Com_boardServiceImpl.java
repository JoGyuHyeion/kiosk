package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Com_boardVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_boardDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_boardServiceImpl implements Com_boardService {

	@Inject
	private Com_boardDAO dao;
	@Inject
	private Vol_checkService volService;
	
	private static final String VERSION="board";
	
	@Override
	public void regist(Com_boardVO vo) throws Exception {
		dao.create(vo);
		volService.update(VERSION);
	}

	@Override
	public Com_boardVO read(Integer bbs_no) throws Exception {
		return dao.read(bbs_no);
	}

	@Override
	public void modify(Com_boardVO vo) throws Exception {
		dao.update(vo);
		volService.update(VERSION);
	}

	@Override
	public void remove(Integer bbs_no) throws Exception {
		dao.delete(bbs_no);
		volService.update(VERSION);
	}

	@Override
	public List<Com_boardVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public int lastInsertID() throws Exception {
		return dao.lastInsertID();
	}

	@Override
	public List<Com_boardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Com_boardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}