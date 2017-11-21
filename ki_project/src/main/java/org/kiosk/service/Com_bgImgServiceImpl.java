package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.domain.Com_bgImgVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_bgImgDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_bgImgServiceImpl implements Com_bgImgService {

	@Inject
	private Com_bgImgDAO dao;
	@Inject
	private Vol_checkService volService;
	
	private static final String VERSION="bgImg";

	@Override
	public void regist(Com_bgImgVO dto) throws Exception {
		dao.create(dto);
		volService.update(VERSION);
	}

	@Override
	public Com_bgImgVO read(Integer ic_no) throws Exception {
		return dao.read(ic_no);
	}

	@Override
	public void modify(Com_bgImgVO dto) throws Exception {
		dao.update(dto);
		volService.update(VERSION);
	}

	@Override
	public void remove(Integer ic_no) throws Exception {
		dao.delete(ic_no);
		volService.update(VERSION);
	}

	@Override
	public List<Com_bgImgVO> listAll() throws Exception {
		return dao.listAll();
	}
	
	@Override
	public List<Com_bgImgVO> jsonList() throws Exception {
		return dao.jsonList();
	}

	@Override
	public int lastInsertID() throws Exception {
		return dao.lastInsertID() + 1;
	}

	@Override
	public List<Com_bgImgVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Com_bgImgVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}
