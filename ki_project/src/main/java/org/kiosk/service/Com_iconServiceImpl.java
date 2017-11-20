package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;

import org.kiosk.domain.Com_iconVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_iconDAO;
import org.kiosk.persistence.Vol_checkDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_iconServiceImpl implements Com_iconService {

	@Inject
	private Com_iconDAO dao;
	@Inject
	private Vol_checkDAO vol_dao;

	@Override
	public void regist(Com_iconVO vo) throws Exception {
		dao.create(vo);
		vol_dao.update("icon");
	}

	@Override
	public Com_iconVO read(Integer ic_no) throws Exception {
		return dao.read(ic_no);
	}

	@Override
	public void modify(Com_iconVO vo) throws Exception {
		dao.update(vo);
		vol_dao.update("icon");
	}

	@Override
	public void remove(Integer ic_no) throws Exception {
		dao.delete(ic_no);
		vol_dao.update("icon");
	}

	@Override
	public List<Com_iconVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public int lastInsertID() throws Exception {
		return dao.lastInsertID() + 1;
	}

	@Override
	public List<Com_iconVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Com_iconVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}
