package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.domain.Com_staff2VO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_staff2DAO;
import org.springframework.stereotype.Service;

@Service
public class Com_staff2ServiceImpl implements Com_staff2Service {

	@Inject
	private Com_staff2DAO dao;
	@Inject
	private Vol_checkService volService;

	private static final String VERSION = "staff";

	@Override
	public void regist(Com_staff2VO vo) throws Exception {
		dao.create(vo);
		volService.update(VERSION);
	}

	@Override
	public Com_staff2VO read(Integer st_no) throws Exception {
		return dao.read(st_no);
	}

	@Override
	public void modify(Com_staff2VO vo) throws Exception {
		dao.update(vo);
		volService.update(VERSION);
	}

	@Override
	public void remove(Integer st_no) throws Exception {
		dao.delete(st_no);
		volService.update(VERSION);
	}

	@Override
	public List<Com_staff2VO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public int lastInsertID() throws Exception {
		return dao.lastInsertID();
	}

	@Override
	public List<Com_staff2VO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Com_staff2VO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public int createSortNo(Com_staff2VO vo) throws Exception {
		return dao.createSortNo(vo);
	}

	@Override
	public void sortupdate(Com_staff2VO vo) throws Exception {
		dao.sortupdate(vo);

	}

}
