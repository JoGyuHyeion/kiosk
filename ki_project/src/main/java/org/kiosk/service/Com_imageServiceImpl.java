package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.domain.Com_imageVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_imageDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_imageServiceImpl implements Com_imageService {

	@Inject
	private Com_imageDAO dao;
	@Inject
	private Vol_checkService volService;
	
	private static final String VERSION="image";

	@Override
	public void regist(Com_imageVO vo) throws Exception {
		dao.create(vo);
		volService.update(VERSION);
	}

	@Override
	public Com_imageVO read(Integer img_no) throws Exception {
		return dao.read(img_no);
	}

	@Override
	public void modify(Com_imageVO vo) throws Exception {
		dao.update(vo);
		volService.update(VERSION);
	}

	@Override
	public void remove(Integer img_no) throws Exception {
		dao.delete(img_no);
		volService.update(VERSION);
	}

	@Override
	public List<Com_imageVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public int lastInsertID() throws Exception {
		return dao.lastInsertID() + 1;
	}

	@Override
	public List<Com_imageVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Com_imageVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}
