package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;
import org.kiosk.dto.Com_buildingDTO;
import org.kiosk.persistence.JsonbuildingDAO;

public class JsonbuildingServiceImpl implements JsonbuildingService {

	@Inject
	private JsonbuildingDAO dao;

	@Override
	public void regist(Com_buildingDTO dto) throws Exception {
		dao.create(dto);

	}

	@Override
	public Com_buildingDTO read(Integer bu_no) throws Exception {
		return dao.read(bu_no);
	}

	@Override
	public void modify(Com_buildingDTO dto) throws Exception {
		dao.update(dto);

	}

	@Override
	public void remove(Integer bu_no) throws Exception {
		dao.delete(bu_no);

	}

	@Override
	public List<Com_buildingDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
