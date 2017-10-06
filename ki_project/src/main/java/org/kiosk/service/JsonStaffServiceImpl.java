package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;

import org.kiosk.domain.Com_sectionVO;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.persistence.JsonStaffDAO;

public class JsonStaffServiceImpl implements JsonStaffService {

	@Inject
	private JsonStaffDAO dao;

//	@Override
//	public void regist(JsonStaffDTO dto) throws Exception {
//		dao.create(dto);
//
//	}

	@Override
	public JsonStaffDTO read(String section_cd) throws Exception {
		return dao.read(section_cd);
	}

	@Override
	public void modify(JsonStaffDTO dto) throws Exception {
		dao.update(dto);

	}

	@Override
	public void remove(String section_cd) throws Exception {
		dao.delete(section_cd);

	}

	@Override
	public List<JsonStaffDTO> listAll(Com_sectionVO vo) throws Exception {
		return dao.listAll(vo);
	}

}
