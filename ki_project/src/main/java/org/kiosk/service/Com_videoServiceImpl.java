package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;

import org.kiosk.domain.Com_videoVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_videoDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_videoServiceImpl implements Com_videoService {

	@Inject
	private Com_videoDAO dao;

	@Override
	public void regist(Com_videoVO dto) throws Exception {
		dao.create(dto);

	}

	@Override
	public Com_videoVO read(Integer vi_no) throws Exception {
		return dao.read(vi_no);

	}

	@Override
	public void modify(Com_videoVO dto) throws Exception {
		dao.update(dto);

	}

	@Override
	public void remove(Integer vi_no) throws Exception {
		dao.delete(vi_no);

	}

	@Override
	public List<Com_videoVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public int lastInsertID() throws Exception {
		return dao.lastInsertID() + 1;
	}

	@Override
	public List<Com_videoVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Com_videoVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}
