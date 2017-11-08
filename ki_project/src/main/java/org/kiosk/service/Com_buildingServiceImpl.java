package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.domain.Com_buildingVO;
import org.kiosk.persistence.Com_buildingDAO;
import org.springframework.stereotype.Service;
@Service
public class Com_buildingServiceImpl implements Com_buildingService {

	@Inject
	private Com_buildingDAO dao;

	@Override
	public void regist(Com_buildingVO dto) throws Exception {
		dao.create(dto);

	}

	@Override
	public Com_buildingVO read(Integer bu_no) throws Exception {
		return dao.read(bu_no);
	}

	@Override
	public void modify(Com_buildingVO dto) throws Exception {
		dao.update(dto);

	}

	@Override
	public void remove(Integer bu_no) throws Exception {
		dao.delete(bu_no);

	}

	@Override
	public List<Com_buildingVO> listAll() throws Exception {
		return dao.listAll();
	}

}
