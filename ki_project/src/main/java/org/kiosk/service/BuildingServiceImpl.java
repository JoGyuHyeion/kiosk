package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.domain.BuildingVO;
import org.kiosk.persistence.BuildingDAO;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Inject
	private BuildingDAO dao;
	@Inject
	private Vol_checkService volService;

	private static final String VERSION = "building";

	@Override
	public void regist(BuildingVO vo) throws Exception {
		dao.create(vo);
		volService.update(VERSION);
	}

	@Override
	public BuildingVO read(Integer bu_no) throws Exception {
		return dao.read(bu_no);
	}

	@Override
	public void modify(BuildingVO vo) throws Exception {
		dao.update(vo);
		volService.update(VERSION);
	}

	@Override
	public void remove(Integer bu_no) throws Exception {
		dao.delete(bu_no);
		volService.update(VERSION);
	}

	@Override
	public List<BuildingVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public int lastInsertID() throws Exception {
		return dao.lastInsertID();
	}

}
