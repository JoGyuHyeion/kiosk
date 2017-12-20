package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.domain.Com_buildingVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_buildingDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_buildingServiceImpl implements Com_buildingService {

	@Inject
	private Com_buildingDAO dao;
	@Inject
	private Vol_checkService volService;

	private static final String VERSION = "building";

	@Override
	public void regist(Com_buildingVO dto) throws Exception {
		dao.create(dto);
		volService.update(VERSION);
	}

	@Override
	public Com_buildingVO read(Integer bu_no) throws Exception {
		return dao.read(bu_no);
	}

	@Override
	public void modify(Com_buildingVO dto) throws Exception {
		dao.update(dto);
		volService.update(VERSION);
	}

	@Override
	public void remove(Integer bu_no) throws Exception {
		dao.delete(bu_no);
		volService.update(VERSION);
	}

	@Override
	public List<Com_buildingVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<Com_buildingVO> list(Integer bu_type) throws Exception {
		return dao.list(bu_type);
	}

	@Override
	public int lastInsertID() throws Exception {
		return dao.lastInsertID();
	}

	@Override
	public List<Com_buildingVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Com_buildingVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}
