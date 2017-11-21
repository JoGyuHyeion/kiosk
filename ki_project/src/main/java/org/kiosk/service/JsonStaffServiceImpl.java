package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.persistence.JsonStaffDAO;
import org.springframework.stereotype.Service;

@Service
public class JsonStaffServiceImpl implements JsonStaffService {

	@Inject
	private JsonStaffDAO dao;
	@Inject
	private Vol_checkService volService;
	
	private static final String VERSION="session";

	@Override
	public void regist(JsonStaffDTO dto) throws Exception {
		dao.create(dto);
		volService.update(VERSION);
	}

	@Override
	public JsonStaffDTO read(String section_cd) throws Exception {
		return dao.read(section_cd);
	}

	@Override
	public void modify(JsonStaffDTO dto) throws Exception {
		dao.update(dto);
		volService.update(VERSION);
	}

	@Override
	public void remove(String section_cd) throws Exception {
		dao.delete(section_cd);
		volService.update(VERSION);
	}

	@Override
	public List<JsonStaffDTO> listAll(String section_fullcode) throws Exception {
		return dao.listAll(section_fullcode);
	}

}