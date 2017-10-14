package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Com_staffVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_staffDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_staffServiceImpl implements Com_staffService {

	@Inject
	private Com_staffDAO dao;

	@Override
	public void regist(Com_staffVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public Com_staffVO read(Integer st_no) throws Exception {
		return dao.read(st_no);
	}

	@Override
	public void modify(Com_staffVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void remove(Integer st_no) throws Exception {
		dao.delete(st_no);
	}

	@Override
	public List<Com_staffVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<Com_staffVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Com_staffVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}
